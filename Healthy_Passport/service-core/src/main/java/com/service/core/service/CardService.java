package com.service.core.service;

import com.service.core.domain.Card;

import java.util.List;

public interface CardService {
    Long create(Card card);
    Card get (Long id);
    void update (Card card);
    void delete (Card card);
    List<Card> findAll();
}
