package com.nnamanx.nexpin.service.impl;

import com.nnamanx.nexpin.exception.CardNotFoundException;
import com.nnamanx.nexpin.model.entity.Card;
import com.nnamanx.nexpin.model.enums.CardStatus;
import com.nnamanx.nexpin.reposiotry.CardRepository;
import com.nnamanx.nexpin.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    @Secured("ROLE_ADMIN")
    public Card issueNewCard(Card card) {

        return cardRepository.save(card);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public Card blockCard(Long cardId) {

        return cardRepository.findById(cardId)
                .map(card -> {
                    card.setStatus(CardStatus.BLOCKED);
                    return cardRepository.save(card);
                })
                .orElseThrow(() -> new CardNotFoundException("Card not found with id: " + cardId));
    }

    @Override
    @Secured("ROLE_ADMIN")
    public Card unblockCard(Long cardId) { // ACTIVATING

        return cardRepository.findById(cardId)
                .map(card -> {
                    card.setStatus(CardStatus.ACTIVE);
                    return cardRepository.save(card);
                })
                .orElseThrow(() -> new CardNotFoundException("Card not found with id: " + cardId));
    }

    @Override
    @Secured("ROLE_ADMIN")
    public void deleteCard(Long cardId) {

        cardRepository.deleteById(cardId);
    }

    @Override
    @Secured("ROLE_ADMIN")
    public List<Card> getAllCardsForClient(Long clientid) {

        return cardRepository.findByClientId(clientid);
    }
}
