package com.service.core.service;

import com.service.core.domain.Doctor;

import java.util.List;

public interface DoctorService {

    Long create(Doctor doctor);
    Doctor get (Long id);
    void update (Doctor doctor);
    void delete (Doctor doctor);
    List<Doctor> findAll();
}
