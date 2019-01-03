package com.api.endpoint;

import com.api.dto.DoctorDTO;
import com.api.dto.PatientDTO;
import com.api.request.DoctorsTypes;
import com.api.request.GeneralRequest;
import com.api.request.directRequest.CreateDoctorRequest;
import com.api.request.directRequest.UpdateDoctorRequest;
import com.api.response.GeneralErrorResponse;
import com.api.response.GeneralResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Aleksandr Borodavka 03.01.2019
 *
 * */

@SwaggerDefinition(info = @Info(description = "Ampula API ", version = "1.0.0", title = "Ampula API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Doctor Service")
@RequestMapping(value = "api/doctor")
public interface DoctorEndpoint {

    @ApiOperation(value = "Add new doctor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    GeneralResponse<Long> addNewDoctor(
            DoctorsTypes doctorsType, GeneralRequest<Void, CreateDoctorRequest> request);


    @ApiOperation(value = "Fire a doctor")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Server error", response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteDoctor(Long doctor_id);


    @ApiOperation(value = "Update doctor data")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Server error", response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    GeneralResponse<Void> updateDoctorData(GeneralRequest<Long, UpdateDoctorRequest> request);


    @ApiOperation(value = "Get doctor data by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Server error", response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<DoctorDTO> getDoctor(Long doctor_id);


    @ApiOperation(value = "Get all doctor's patients")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Server error", response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/get/all/patients", method = RequestMethod.GET)
    GeneralResponse<List<PatientDTO>> getAllPatients(Long doctor_id);


    @ApiOperation(value = "Get all doctors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    GeneralResponse<List<DoctorDTO>> getAll();


}
