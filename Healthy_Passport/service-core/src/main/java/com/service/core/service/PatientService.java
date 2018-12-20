package com.service.core.service;


import com.service.core.domain.Patient;

import java.util.List;

/***
 *
 *
 * 20.12.2018 by Yaroslav Halindzovskiy
 * */
public interface PatientService {


    Long create(Patient patient);

    Patient get(Long id);

    void update(Patient patient);

    void delete(Patient patient);

    List<Patient> findAll();
}
