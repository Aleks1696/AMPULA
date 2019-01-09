package com.service.core.util;

import com.api.dto.CardDTO;
import com.api.dto.PatientDTO;
import com.service.core.domain.Card;
import com.service.core.domain.Patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr Borodavka 03.01.2019
 *
 * */

public class CardMapper {

    public static CardDTO cardToCardDTO(Card card, Patient patient){
        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(card.getId());
        cardDTO.setHeight(card.getHeight());
        cardDTO.setWeight(card.getWeight());
        cardDTO.setGender(card.getGender().toString());
        cardDTO.setHistory(card.getHistory());
        cardDTO.setHospital(card.getHospital());
        cardDTO.setName(patient.getName());
        cardDTO.setSurname(patient.getSurname());
        cardDTO.setBirthday(patient.getBirthday().toString());
        return cardDTO;
    }

    public static List<CardDTO> cardsToCardsDTOList(List<Card> cards){
        List<CardDTO> cardDTOList = new ArrayList<CardDTO>();
        for (Card card : cards){
            cardDTOList.add(cardToCardDTO(card, card.getPatient()));
        }
        return cardDTOList;
    }
}
