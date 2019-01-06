package com.service.core.endpoint;

import com.api.dto.PatientDTO;
import com.api.endpoint.PatientEndpoint;
import com.api.request.GeneralRequest;
import com.api.request.directRequest.CreatePatientRequest;
import com.api.request.directRequest.UpdatePatientRequest;
import com.api.response.GeneralResponse;
import com.service.core.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestEndpoint implements PatientEndpoint {

    @Autowired
    private PatientService patientService;

    public GeneralResponse<Long> createPatient(
            @RequestBody GeneralRequest<Void, CreatePatientRequest> request) {
        return new GeneralResponse<Long>(
                200L, patientService.createPatient(request.getParameters()));
    }

    public GeneralResponse<Void> updatePatient(
            @RequestBody GeneralRequest<Long, UpdatePatientRequest> request) {
        patientService.updatePatient(request.getId(), request.getParameters());
        return new GeneralResponse<Void>(200L, null);
    }

    public GeneralResponse<Void> deletePatient(
            @RequestParam Long patient_id) {
        patientService.deletePatient(patient_id);
        return new GeneralResponse<Void>(200L, null);
    }

    public GeneralResponse<PatientDTO> getPatientData(
            @RequestParam Long patient_id) {
        return new GeneralResponse<PatientDTO>(
                200L, patientService.getPatientData(patient_id));
    }

    public GeneralResponse<List<PatientDTO>> getAllPatients() {
        return new GeneralResponse<List<PatientDTO>>(
                200L, patientService.getAllPatients());
    }
}
