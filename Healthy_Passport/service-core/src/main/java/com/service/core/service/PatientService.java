package com.service.core.service;


import com.api.dto.PatientDTO;
import com.api.request.GeneralRequest;
import com.api.request.directRequest.CreatePatientRequest;
import com.api.request.directRequest.UpdatePatientRequest;
import com.service.core.domain.Patient;

import java.util.List;

/***
 *
 *
 * 20.12.2018 by Yaroslav Halindzovskiy
 * */
public interface PatientService {

    Long createPatient(CreatePatientRequest parameters);

    void updatePatient(Long id, UpdatePatientRequest parameters);

    void deletePatient(Long id);

    PatientDTO getPatientData(Long id);

    List<PatientDTO> getAllPatients();
}
