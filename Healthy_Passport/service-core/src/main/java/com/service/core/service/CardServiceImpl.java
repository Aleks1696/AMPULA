package com.service.core.service;

import com.api.dto.CardDTO;
import com.api.dto.PatientDTO;
import com.api.request.directRequest.CreateCardRequest;
import com.api.request.directRequest.UpdateCardRequest;
import com.service.core.dao.CardRepository;
import com.service.core.dao.PatientRepository;
import com.service.core.domain.Card;
import com.service.core.domain.Patient;
import com.service.core.domain.types.Gender;
import com.service.core.exception.EntryIsNotFoundException;
import com.service.core.util.CardMapper;
import com.service.core.util.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

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

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, PatientRepository patientRepository) {
        this.cardRepository = cardRepository;
        this.patientRepository = patientRepository;
    }

    public Long createCard(CreateCardRequest parameters) {
        Patient patient = patientRepository.findOne(parameters.getPatient());
        if (patient == null){
            throw new EntryIsNotFoundException(500L,
                    String.format("Patient with id = %d is not found", parameters.getPatient()));
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

        cardRepository.saveAndFlush(card);

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
        Patient patient = patientRepository.findOne(card.getPatient().getId());
        patient.setCard(null);
        patientRepository.saveAndFlush(patient);
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
        return CardMapper.cardToCardDTO(card);
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
