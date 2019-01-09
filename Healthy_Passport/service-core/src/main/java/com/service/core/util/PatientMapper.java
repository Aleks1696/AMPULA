package com.service.core.util;

import com.api.dto.CardDTO;
import com.api.dto.PatientDTO;
import com.service.core.domain.Patient;

import java.util.ArrayList;
import java.util.List;

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
        patientDTO.setBirthday(patient.getBirthday().toString());
        if (patient.getCard() == null){
            patientDTO.setCard(null);
        } else {
            patientDTO.setCard(patient.getCard().getId().toString());
        }

        return patientDTO;
    }

    public static List<PatientDTO> patientsToPatinetsDTOList(List<Patient> patients){
        List<PatientDTO> patientDTOList = new ArrayList<>();
        for (Patient patient : patients){
            patientDTOList.add(patientToPatientDTO(patient));
        }
        return patientDTOList;
    }

}
