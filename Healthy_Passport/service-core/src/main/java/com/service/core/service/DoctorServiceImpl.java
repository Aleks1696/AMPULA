package com.service.core.service;

import com.api.dto.DoctorDTO;
import com.api.dto.PatientDTO;
import com.service.core.domain.types.DoctorsTypes;
import com.api.request.directRequest.CreateDoctorRequest;
import com.api.request.directRequest.UpdateDoctorRequest;
import com.service.core.dao.DoctorRepository;
import com.service.core.dao.PatientRepository;
import com.service.core.domain.Doctor;
import com.service.core.exception.EntryIsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {


    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
@Autowired
    public DoctorServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public Long addNewDoctor(CreateDoctorRequest parameters) {
        Doctor doctor = new Doctor();
        doctor.setName(parameters.getName());
        doctor.setSurname(parameters.getSurname());
        doctor.setDoctorsTypes(parameters.getDoctorType());
        doctorRepository.saveAndFlush(doctor);


    return doctor.getId();
    }

    public void deleteDoctor(Long id) {
    Doctor doctor = doctorRepository.findOne(id);
    if (doctor == null){
        throw new EntryIsNotFoundException(500L,String.format("Doctor with id = %id is not found",id));
    }
    doctorRepository.delete(id);

    }

    public void updateDoctorData(Long id, UpdateDoctorRequest parameters) {
Doctor doctor = doctorRepository.findOne(id);
if(doctor == null){
    throw new EntryIsNotFoundException(500L,String.format("Doctor with id =%id is not found",id));
}

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
