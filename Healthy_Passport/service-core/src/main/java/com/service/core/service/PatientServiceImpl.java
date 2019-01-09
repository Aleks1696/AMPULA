package com.service.core.service;

import com.api.dto.PatientDTO;
import com.api.request.directRequest.CreatePatientRequest;
import com.api.request.directRequest.UpdatePatientRequest;
import com.service.core.dao.CardRepository;
import com.service.core.dao.DoctorRepository;
import com.service.core.dao.PatientRepository;
import com.service.core.domain.Card;
import com.service.core.domain.Doctor;
import com.service.core.domain.Patient;
import com.service.core.exception.EntryIsNotFoundException;
import com.service.core.util.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private CardRepository cardRepository;
    private DoctorRepository doctorRepository;

    //мы получаем строку из CreatePatientRequest в формате String. Задаем формат даты
    private DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, CardRepository cardRepository,
                              DoctorRepository doctorRepository) {
        this.patientRepository = patientRepository;
        this.cardRepository = cardRepository;
        this.doctorRepository = doctorRepository;
    }

    public Long createPatient(CreatePatientRequest parameters) {
        Patient patient = new Patient();
        if (patientRepository.findByNameAndSurnameEquals(
                parameters.getName(), parameters.getSurname()) != null){
            throw new EntryIsNotFoundException(
                    500L, String.format("Patient with name: '%s' and surname: '%s' is already registered",
                    parameters.getName(), parameters.getSurname()));
        }
        patient.setName(parameters.getName());
        patient.setSurname(parameters.getSurname());
        patient.setBirthday(LocalDate.parse(parameters.getBirthday(), parser));
        return patientRepository.saveAndFlush(patient).getId();
    }

    public void updatePatient(Long id, UpdatePatientRequest parameters) {
        Patient patient = patientRepository.findOne(id);
        if (patient == null){
            throw new EntryIsNotFoundException(
                    500L, String.format("Patient with id = %d is not found", id));
        }
        patient.setName(parameters.getName());
        patient.setSurname(parameters.getSurname());
        patient.setBirthday(LocalDate.parse(parameters.getBirthday(), parser));
        patientRepository.saveAndFlush(patient);
    }

    public void deletePatient(Long id) {
        Patient patient = patientRepository.findOne(id);
        if (patient == null){
            throw new EntryIsNotFoundException(
                    500L, String.format("Patient with id = %d is not found", id));
        }
        patient.getCard().removeCard(doctorRepository, cardRepository);
        patientRepository.delete(id);
    }

    public PatientDTO getPatientData(Long id) {
        Patient patient = patientRepository.findOne(id);
        if (patient == null){
            throw new EntryIsNotFoundException(
                    500L, String.format("Patient with id = %d is not found", id));
        }
        return PatientMapper.patientToPatientDTO(patient);
    }

    public List<PatientDTO> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return PatientMapper.patientsToPatinetsDTOList(patientList);
    }
}
