package com.service.core.service;

import com.api.dto.DoctorDTO;
import com.api.dto.PatientDTO;
import com.api.request.DoctorsTypes;
import com.api.request.directRequest.CreateDoctorRequest;
import com.api.request.directRequest.UpdateDoctorRequest;
import com.service.core.dao.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Long addNewDoctor(DoctorsTypes doctorsType, CreateDoctorRequest parameters) {
        return null;
    }

    public void deleteDoctor(Long id) {

    }

    public void updateDoctorData(Long id, UpdateDoctorRequest parameters) {

    }

    public DoctorDTO getDoctor(Long id) {
        return null;
    }

    public List<PatientDTO> getAllPatients(Long id) {
        return null;
    }

    public List<DoctorDTO> getAll() {
        return null;
    }
}
