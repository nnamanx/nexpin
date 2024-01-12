package com.nnamanx.nexpin.controller;

import com.nnamanx.nexpin.model.entity.Card;
import com.nnamanx.nexpin.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nexpin/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping("/issue")
    public ResponseEntity<Card> issueNewCard(@RequestBody Card card) {

        Card issuedCard = cardService.issueNewCard(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(issuedCard);
    }

    @PostMapping("/block/{cardId}")
    public ResponseEntity<Card> blockCard(@PathVariable Long cardId) {

        Card blockedCard = cardService.blockCard(cardId);
        return ResponseEntity.ok(blockedCard);
    }

    @PostMapping("/unblock/{cardId}")
    public ResponseEntity<Card> unblockCard(@PathVariable Long cardId) {

        Card unblockedCard = cardService.unblockCard(cardId);
        return ResponseEntity.ok(unblockedCard);
    }

    @DeleteMapping("/delete/{cardId}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long cardId) {

        cardService.deleteCard(cardId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/all/{clientId}")
    public ResponseEntity<List<Card>> getAllCardsForClient(@PathVariable Long clientId) {

        List<Card> cards = cardService.getAllCardsForClient(clientId);
        return ResponseEntity.ok(cards);
    }
}
