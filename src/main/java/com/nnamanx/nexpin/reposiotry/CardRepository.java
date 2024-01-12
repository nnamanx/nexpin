package com.nnamanx.nexpin.reposiotry;

import com.nnamanx.nexpin.model.entity.Account;
import com.nnamanx.nexpin.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findByClientId(Long clientId);

}
