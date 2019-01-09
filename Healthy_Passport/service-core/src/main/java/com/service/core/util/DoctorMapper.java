package com.service.core.util;

import com.api.dto.DoctorDTO;
import com.api.dto.PatientDTO;
import com.service.core.domain.Doctor;
import com.service.core.domain.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr Borodavka 08.01.2019
 *
 * */

public class DoctorMapper {

    public static DoctorDTO doctorToDoctorDTO(Doctor doctor){
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(doctor.getId());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSurname(doctor.getSurname());
        doctorDTO.setDoctorType(doctor.getDoctorsTypes().toString());
        return doctorDTO;
    }

    public static List<DoctorDTO> doctorToDoctorDTOList(List<Doctor> doctorList){
        List<DoctorDTO> doctorDTOList = new ArrayList<DoctorDTO>();
        for (Doctor doctor : doctorList){
            doctorDTOList.add(doctorToDoctorDTO(doctor));
        }
        return doctorDTOList;
    }
}
