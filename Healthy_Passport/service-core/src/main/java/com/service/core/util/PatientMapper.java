package com.service.core.util;

import com.api.dto.PatientDTO;
import com.service.core.domain.Patient;

/**
 * Created by Aleksandr Borodavka 03.01.2019
 *
 * */

public class PatientMapper {

    public static PatientDTO patientToPatientDTO(Patient patient){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setId(patient.getId());
        patientDTO.setName(patient.getName());
        patientDTO.setSurname(patient.getSurname());
        patientDTO.setBirthday(patient.getBirthday());
        patientDTO.setCard(patient.getCard().getId().toString());
        return patientDTO;
    }
}
