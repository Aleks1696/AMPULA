package com.service.core.util;

import com.api.dto.CardDTO;
import com.service.core.domain.Card;

/**
 * Created by Aleksandr Borodavka 03.01.2019
 *
 * */

public class CardMapper {

    public static CardDTO cardToCardDTO(Card card){
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setHeight(card.getHeight());
        cardDTO.setWeight(card.getWeight());
        cardDTO.setGender(card.getGender().toString());
        cardDTO.setHistory(card.getHistory());
        cardDTO.setHospital(card.getHospital());
        cardDTO.setPatient(card.getPatient().getId().toString());
        return cardDTO;
    }
}
