package com.service.core.service;

import com.api.dto.PatientDTO;
import com.api.request.directRequest.CreatePatientRequest;
import com.api.request.directRequest.UpdatePatientRequest;
import com.service.core.dao.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Long createPatient(CreatePatientRequest parameters) {
        return null;
    }

    public void updatePatient(Long id, UpdatePatientRequest parameters) {

    }

    public void deletePatient(Long id) {

    }

    public PatientDTO getPatientData(Long id) {
        return null;
    }

    public List<PatientDTO> getAllPatients() {
        return null;
    }
}
