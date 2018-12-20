package com.service.core.service;

import com.service.core.dao.CardRepository;
import com.service.core.domain.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *
 * Creater by Yaroslav Halindzovskiy 20.12.2018
 * */
@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;
@Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Long create(Card card) {

        return cardRepository.saveAndFlush(card).getId();
    }

    public Card get(Long id) {

        return null;
    }

    public void update(Card card) {

    }

    public void delete(Card card) {

    }

    public List<Card> findAll() {
        return null;
    }
}
