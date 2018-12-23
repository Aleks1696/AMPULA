package com.api.endpoint;

import com.api.dto.DoctorDTO;
import com.api.dto.PatientDTO;
import com.api.request.DoctorsTypes;
import com.api.request.GeneralRequest;
import com.api.request.directRequest.CreateDoctorRequest;
import com.api.request.directRequest.UpdateDoctorRequest;
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
@Api(tags = "Doctor Service")
@RequestMapping(value = "api/doctor")
public interface DoctorEndpoint {

    @ApiOperation(value = "Add new doctor")
    @ApiResponses({

    })
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    GeneralResponse<Long> addNewDoctor(
            DoctorsTypes doctorsType, GeneralRequest<Void, CreateDoctorRequest> request);


    @ApiOperation(value = "Fire a doctor")
    @ApiResponses({

    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteDoctor(Long doctor_id);


    @ApiOperation(value = "Update doctor data")
    @ApiResponses({

    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    GeneralResponse<Void> updateDoctorData(GeneralRequest<Long, UpdateDoctorRequest> request);


    @ApiOperation(value = "Get doctor data by ID")
    @ApiResponses({

    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<DoctorDTO> getDoctor(Long doctor_id);


    @ApiOperation(value = "Get all doctor's patients")
    @ApiResponses({

    })
    @RequestMapping(value = "/get/all/patients", method = RequestMethod.GET)
    GeneralResponse<List<PatientDTO>> getAllPatients(Long doctor_id);


    @ApiOperation(value = "Get all doctors")
    @ApiResponses({

    })
    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    GeneralResponse<List<DoctorDTO>> getAll();


}
