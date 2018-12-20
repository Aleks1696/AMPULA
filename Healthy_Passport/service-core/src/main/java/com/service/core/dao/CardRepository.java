package com.service.core.dao;

import com.service.core.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByIdEquals(Long id);
}
