package com.service.core.endpoint;

import com.api.dto.CardDTO;
import com.api.dto.PatientDTO;
import com.api.endpoint.CardEndpoint;
import com.api.request.GeneralRequest;
import com.api.request.directRequest.CreateCardRequest;
import com.api.request.directRequest.UpdateCardRequest;
import com.api.response.GeneralResponse;
import com.service.core.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardRestEndpoint implements CardEndpoint {

    @Autowired
    private CardService cardService;

    public GeneralResponse<Long> createCard(
            @RequestBody GeneralRequest<Void, CreateCardRequest> request) {
        return new GeneralResponse<Long>(
                200L, cardService.createCard(request.getParameters()));
    }

    public GeneralResponse<Void> deleteCardById(
            @RequestParam Long card_id) {
        cardService.deleteCardById(card_id);
        return new GeneralResponse<Void>(200L, null);
    }

    public GeneralResponse<Void> updateCard(
            @RequestBody GeneralRequest<Long, UpdateCardRequest> request) {
        cardService.updateCard(request.getId(), request.getParameters());
        return new GeneralResponse<Void>(200L, null);
    }

    public GeneralResponse<CardDTO> getCardData(
            @RequestParam Long card_id) {
        return new GeneralResponse<CardDTO>(
                200L, cardService.getCardData(card_id));
    }

    public GeneralResponse<PatientDTO> getCardOwnerData(
            @RequestParam Long card_id) {
        return new GeneralResponse<PatientDTO>(
                200L, cardService.getCardOwnerData(card_id));
    }
}
