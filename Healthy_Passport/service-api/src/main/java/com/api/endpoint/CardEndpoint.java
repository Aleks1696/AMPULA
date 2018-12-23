package com.api.endpoint;


import com.api.dto.CardDTO;
import com.api.dto.PatientDTO;
import com.api.request.GeneralRequest;
import com.api.request.directRequest.CreateCardRequest;
import com.api.request.directRequest.UpdateCardRequest;
import com.api.response.GeneralResponse;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@SwaggerDefinition(info = @Info(description = "Ampula API ", version = "1.0.0", title = "Ampula API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Card Service ", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,protocols = "https")
@RequestMapping(value = "api/card/")

public interface CardEndpoint {

    @ApiOperation(value = "Create new card for patient")
    @ApiResponses({

    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createCard(GeneralRequest<Void, CreateCardRequest> request);


    @ApiOperation(value = "Delete patient card by card id")
    @ApiResponses({

    })
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    GeneralResponse<Void> deleteCardById(Long card_id);


    @ApiOperation(value = "Update patient's card data")
    @ApiResponses({

    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    GeneralResponse<Void> updateCard(GeneralRequest<Long, UpdateCardRequest> request);


    @ApiOperation(value = "Get card data by ID")
    @ApiResponses({

    })
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    GeneralResponse<CardDTO> getCardData(Long card_id);

    //получаем данные клиента через ИД карты (карта и клиент у нас связаны)
    @ApiOperation(value = "Get card owner data by card ID")
    @ApiResponses({

    })
    @RequestMapping(value = "/get/owner/data", method = RequestMethod.GET)
    GeneralResponse<PatientDTO> getCardOwnerData(Long card_id);






    /*
    *
    *
    * @SwaggerDefinition(
        info = @Info(description = "Management API", version = "1.0.0", title = "Management API"),
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        schemes = SwaggerDefinition.Scheme.HTTPS
)
@Api(tags = "Account Service", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, protocols = "https")
@RequestMapping(value = "management/account")
public interface AccountEndpoint {

    @ApiOperation(value = "Create new account for client record")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK - Account record is created"),
            @ApiResponse(code = 500, message = "FAIL - Internal server error",
                    response = GeneralErrorResponse.class)
    })
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    GeneralResponse<Long> createAccount(GeneralRequest<Void, AccountParametrs> accountRequest);
    * */
}
