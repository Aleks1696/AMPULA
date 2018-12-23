package com.api.endpoint;

import com.api.dto.PatientDTO;
import com.api.request.GeneralRequest;
import com.api.request.directRequest.CreateDoctorRequest;
import com.api.request.directRequest.CreatePatientRequest;
import com.api.request.directRequest.UpdatePatientRequest;
import com.api.response.GeneralResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@SwaggerDefinition(info = @Info(description = "Ampula API ", version = "1.0.0", title = "Ampula API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Client Service", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, protocols = "https")
@RequestMapping(value = "api/patient")
public interface PatientEndpoint {

    @ApiOperation(value = "Create new patient")
    @ApiResponses({

    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createPatient(GeneralRequest<Void, CreatePatientRequest> request);


    @ApiOperation(value = "Update patient data")
    @ApiResponses({

    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    GeneralResponse<Void> updatePatient(GeneralRequest<Long, UpdatePatientRequest> request);


    @ApiOperation(value = "Delete patient")
    @ApiResponses({

    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deletePatient(Long patient_id);


    @ApiOperation(value = "Get patient data")
    @ApiResponses({

    })
    @RequestMapping(value = "/get/data", method = RequestMethod.GET)
    GeneralResponse<PatientDTO> getPatientData(Long patient_id);


    @ApiOperation(value = "Get all patients")
    @ApiResponses({

    })
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    GeneralResponse<List<PatientDTO>> getAllPatients();


}
