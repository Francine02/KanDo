package com.carolina.backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolina.backend.controllers.swagger.CardControllerSwagger;
import com.carolina.backend.dtos.request.CardRequestDTO;
import com.carolina.backend.dtos.response.CardResponseDTO;
import com.carolina.backend.services.CardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController implements CardControllerSwagger {

    private final CardService cardService;

    @GetMapping("/{boardId}")
    public ResponseEntity<List<CardResponseDTO>> allCards(@PathVariable Long boardId) {
        List<CardResponseDTO> cards = cardService.allCards(boardId);

        return ResponseEntity.ok(cards);
    }

    @PostMapping("/create/{boardId}")
    public ResponseEntity<CardResponseDTO> createCard(@RequestBody CardRequestDTO cardRequestDTO,
            @PathVariable Long boardId) {
        CardResponseDTO card = cardService.saveCard(cardRequestDTO, boardId);
        return ResponseEntity.status(201).body(card);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardResponseDTO> updateCard(@RequestBody CardRequestDTO cardRequestDTO,
            @PathVariable Long id) {
        CardResponseDTO card = cardService.updateCard(id, cardRequestDTO);
        return ResponseEntity.ok(card);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}
