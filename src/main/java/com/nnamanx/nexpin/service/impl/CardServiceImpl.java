package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.model.entity.Card;
import com.nnamanx.nexpin.reposiotry.CardRepository;
import com.nnamanx.nexpin.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public Card issueNewCard(Card card) {
        return null;
    }

    @Override
    public Card blockCard(Long cardId) {
        return null;
    }

    @Override
    public Card unblockCard(Long cardId) {
        return null;
    }

    @Override
    public void deleteCard(Long cardId) {

    }

    @Override
    public List<Card> getAllCardsForClient(Long clientid) {
        return null;
    }
}
