package com.service.core.service;

import com.api.dto.CardDTO;
import com.api.dto.PatientDTO;
import com.api.request.directRequest.CreateCardRequest;
import com.api.request.directRequest.UpdateCardRequest;
import com.service.core.domain.Card;

import java.util.List;

public interface CardService {

    Long createCard(CreateCardRequest parameters);

    void deleteCardById (Long id);

    void updateCard (Long id, UpdateCardRequest parameters);

    CardDTO getCardData (Long id);

    PatientDTO getCardOwnerData (Long cardId);

//    List<Card> findAll();
}
