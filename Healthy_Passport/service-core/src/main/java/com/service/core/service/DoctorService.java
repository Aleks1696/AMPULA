package com.service.core.service;

import com.api.dto.CardDTO;
import com.api.dto.DoctorDTO;
import com.api.request.directRequest.CreateDoctorRequest;
import com.api.request.directRequest.UpdateDoctorRequest;

import java.util.List;

public interface DoctorService {

    Long addNewDoctor(CreateDoctorRequest parameters);

    void deleteDoctor (Long id);

    void updateDoctorData (Long id, UpdateDoctorRequest parameters);

    DoctorDTO getDoctor (Long id);

    List<CardDTO> getAllPatients(Long id);

    List<DoctorDTO> getAll();
}
