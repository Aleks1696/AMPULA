package com.service.core.service;

import com.api.dto.DoctorDTO;
import com.api.dto.PatientDTO;
import com.api.request.DoctorsTypes;
import com.api.request.directRequest.CreateDoctorRequest;
import com.api.request.directRequest.UpdateDoctorRequest;
import com.service.core.domain.Doctor;

import java.util.List;

public interface DoctorService {

    Long addNewDoctor(DoctorsTypes doctorsType, CreateDoctorRequest parameters);

    void deleteDoctor (Long id);

    void updateDoctorData (Long id, UpdateDoctorRequest parameters);

    DoctorDTO getDoctor (Long id);

    List<PatientDTO> getAllPatients(Long id);

    List<DoctorDTO> getAll();
}
