package com.service.core.service;

import com.api.dto.CardDTO;
import com.api.dto.DoctorDTO;
import com.service.core.dao.CardRepository;
import com.service.core.domain.Card;
import com.api.request.directRequest.CreateDoctorRequest;
import com.api.request.directRequest.UpdateDoctorRequest;
import com.service.core.dao.DoctorRepository;
import com.service.core.dao.PatientRepository;
import com.service.core.domain.Doctor;
import com.service.core.exception.EntryIsNotFoundException;
import com.service.core.util.CardMapper;
import com.service.core.util.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Aleksandr Borodavka 08.01.2019
 * updateDoctorData
 * getDoctor
 * getAllPatients
 * getAll
 *
 * */

@Service
public class DoctorServiceImpl implements DoctorService {


    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private CardRepository cardRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository,
                             CardRepository cardRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.cardRepository = cardRepository;
    }

    public Long addNewDoctor(CreateDoctorRequest parameters) {
        Doctor doctor = new Doctor();
        doctor.setName(parameters.getName());
        doctor.setSurname(parameters.getSurname());
        doctor.setDoctorsTypes(parameters.getDoctorsTypes());
        doctorRepository.saveAndFlush(doctor);
        return doctor.getId();
    }

    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findOne(id);
        if (doctor == null) {
            throw new EntryIsNotFoundException(500L, String.format("Doctor with id = %id is not found", id));
        }
        doctor.removeDoctor(doctorRepository, cardRepository);
        doctorRepository.delete(id);
    }

    public void updateDoctorData(Long id, UpdateDoctorRequest parameters) {
        Doctor doctor = doctorRepository.findOne(id);
        if (doctor == null) {
            throw new EntryIsNotFoundException(500L, String.format("Doctor with id =%d is not found", id));
        }
        doctor.setName(parameters.getName());
        doctor.setSurname(parameters.getSurname());
        doctor.setDoctorsTypes(parameters.getDoctorsTypes());
        doctorRepository.saveAndFlush(doctor);
    }

    public DoctorDTO getDoctor(Long id) {
        Doctor doctor = doctorRepository.findOne(id);
        if (doctor == null) {
            throw new EntryIsNotFoundException(500L, String.format("Doctor with id =%d is not found", id));
        }
        return DoctorMapper.doctorToDoctorDTO(doctor);
    }

    public List<CardDTO> getAllPatients(Long id) {
        Doctor doctor = doctorRepository.findOne(id);
        if (doctor == null) {
            throw new EntryIsNotFoundException(500L, String.format("Doctor with id =%d is not found", id));
        }
        List<Card> cardList = doctor.getCards();
        return CardMapper.cardsToCardsDTOList(cardList);
    }

    public List<DoctorDTO> getAll() {
        List<Doctor> doctorList = doctorRepository.findAll();
        return DoctorMapper.doctorToDoctorDTOList(doctorList);
    }
}
