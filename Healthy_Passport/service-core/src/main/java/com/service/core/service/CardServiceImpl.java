package com.service.core.service;

import com.api.dto.CardDTO;
import com.api.dto.PatientDTO;
import com.api.request.directRequest.CreateCardRequest;
import com.api.request.directRequest.UpdateCardRequest;
import com.service.core.dao.CardRepository;
import com.service.core.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * Creater by Yaroslav Halindzovskiy 20.12.2018
 *
 * */
@Service
public class CardServiceImpl implements CardService {

    private CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Long createCard(CreateCardRequest parameters) {
        return null;
    }

    public void deleteCardById(Long id) {

    }

    public void updateCard(Long id, UpdateCardRequest parameters) {

    }

    public CardDTO getCardData(Long id) {
        return null;
    }

    public PatientDTO getCardOwnerData(Long cardId) {
        return null;
    }
}
