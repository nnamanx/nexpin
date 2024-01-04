package com.nnamanx.nexpin.service;

import com.nnamanx.nexpin.model.entity.Card;

import java.util.List;

public interface CardService {

    Card issueNewCard(Card card);
    Card blockCard(Long cardId);
    Card unblockCard(Long cardId);
    void deleteCard(Long cardId);
    List<Card> getAllCardsForClient(Long clientid);
}
