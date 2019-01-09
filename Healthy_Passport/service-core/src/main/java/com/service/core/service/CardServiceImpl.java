package com.service.core.service;

import com.api.dto.CardDTO;
import com.api.dto.PatientDTO;
import com.api.request.directRequest.CreateCardRequest;
import com.api.request.directRequest.UpdateCardRequest;
import com.service.core.dao.CardRepository;
import com.service.core.dao.DoctorRepository;
import com.service.core.dao.PatientRepository;
import com.service.core.domain.Card;
import com.service.core.domain.Doctor;
import com.service.core.domain.Patient;
import com.api.request.types.Gender;
import com.service.core.exception.EntryIsNotFoundException;
import com.service.core.util.CardMapper;
import com.service.core.util.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Creater by Yaroslav Halindzovskiy 20.12.2018
 *
 * Implemented by Aleksandr Borodavka 03.01.2019
 *
 * */
@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, PatientRepository patientRepository,
                           DoctorRepository doctorRepository) {
        this.cardRepository = cardRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public Long createCard(CreateCardRequest parameters) {
        Patient patient = patientRepository.findOne(parameters.getPatientId());
        Doctor doctor = doctorRepository.findOne(parameters.getDoctorId());
        if (patient == null){
            throw new EntryIsNotFoundException(500L,
                    String.format("Patient with id = %d is not found", parameters.getPatientId()));
        } else if (doctor == null){
            throw new EntryIsNotFoundException(
                    500L, String.format("Doctor with id = %d is not found", parameters.getDoctorId()));
        }
        Card card = new Card();
        card.setHeight(parameters.getHeight());
        card.setWeight(parameters.getWeight());

        if (parameters.getGender().equalsIgnoreCase("Male")){
            card.setGender(Gender.MALE);
        } else {
            card.setGender(Gender.FEMALE);
        }
        card.setHistory(parameters.getHistory());
        card.setHospital(parameters.getHospital());
        card.setPatient(patient);
        card.getDoctors().add(doctor);

        cardRepository.saveAndFlush(card);

        //сетим в карту доктора, а доктору карту
        doctor.getCards().add(card);
        doctorRepository.saveAndFlush(doctor);
        //сетим пациенту карту
        patient.setCard(card);
        patientRepository.saveAndFlush(patient);

        return card.getId();
    }

    public void deleteCardById(Long id) {
        Card card = cardRepository.findOne(id);
        if (card == null){
            throw new EntryIsNotFoundException(
                    500L, String.format("Card with id = %d is not found", id));
        }
        card.removeCard(doctorRepository, cardRepository);
        cardRepository.delete(card);
    }

    public void updateCard(Long id, UpdateCardRequest parameters) {
        Card card = cardRepository.findOne(id);
        if (card == null){
            throw new EntryIsNotFoundException(
                    500L, String.format("Card with id = %d is not found", id));
        }
        card.setHeight(parameters.getHeight());
        card.setWeight(parameters.getWeight());

        if (parameters.getGender().equalsIgnoreCase("male")){
            card.setGender(Gender.MALE);
        } else {
            card.setGender(Gender.FEMALE);
        }
        card.setHistory(parameters.getHistory());
        card.setHospital(parameters.getHospital());
        cardRepository.saveAndFlush(card);
    }

    public CardDTO getCardData(Long id) {
        Card card = cardRepository.findOne(id);
        if (card == null){
            throw new EntryIsNotFoundException(
                    500L, String.format("Card with id = %d is not found", id));
        }
        return CardMapper.cardToCardDTO(card, card.getPatient());
    }

    public PatientDTO getCardOwnerData(Long cardId) {
        Card card = cardRepository.findOne(cardId);
        if (card == null){
            throw new EntryIsNotFoundException(
                    500L, String.format("Card with id = %d is not found", cardId));
        }
        return PatientMapper.patientToPatientDTO(card.getPatient());
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }
}
