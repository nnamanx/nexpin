package com.nnamanx.nexpin.reposiotry;

import com.nnamanx.nexpin.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
