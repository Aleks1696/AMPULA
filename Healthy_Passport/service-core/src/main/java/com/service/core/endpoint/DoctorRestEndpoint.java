package com.service.core.endpoint;

import com.api.dto.CardDTO;
import com.api.dto.DoctorDTO;
import com.api.endpoint.DoctorEndpoint;
import com.api.request.GeneralRequest;
import com.api.request.directRequest.CreateDoctorRequest;
import com.api.request.directRequest.UpdateDoctorRequest;
import com.api.response.GeneralResponse;
import com.service.core.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorRestEndpoint implements DoctorEndpoint {

    @Autowired
    private DoctorService doctorService;

    public GeneralResponse<Long> addNewDoctor(
            @RequestBody GeneralRequest<Void, CreateDoctorRequest> request) {
        return new GeneralResponse<Long>(
                200L, doctorService.addNewDoctor(request.getParameters()));
    }

    public GeneralResponse<Void> deleteDoctor(
            @RequestParam Long doctor_id) {
        doctorService.deleteDoctor(doctor_id);
        return new GeneralResponse<Void>(200L, null);
    }

    public GeneralResponse<Void> updateDoctorData(
            @RequestBody GeneralRequest<Long, UpdateDoctorRequest> request) {
        doctorService.updateDoctorData(request.getId(), request.getParameters());
        return new GeneralResponse<Void>(200L, null);
    }

    public GeneralResponse<DoctorDTO> getDoctor(
            @RequestParam Long doctor_id) {
        return new GeneralResponse<DoctorDTO>(
                200L, doctorService.getDoctor(doctor_id));
    }

    public GeneralResponse<List<CardDTO>> getAllPatients(
            @RequestParam Long doctor_id) {
        return new GeneralResponse<List<CardDTO>>(
                200L, doctorService.getAllPatients(doctor_id));
    }

    public GeneralResponse<List<DoctorDTO>> getAll() {
        return new GeneralResponse<List<DoctorDTO>>(200L, doctorService.getAll());
    }
}
