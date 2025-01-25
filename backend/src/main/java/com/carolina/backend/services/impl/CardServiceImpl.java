package com.carolina.backend.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.carolina.backend.dtos.request.CardRequestDTO;
import com.carolina.backend.dtos.response.CardResponseDTO;
import com.carolina.backend.exceptions.InvalidRequestException;
import com.carolina.backend.exceptions.ResourceNotFoundException;
import com.carolina.backend.exceptions.ServiceUnavailableException;
import com.carolina.backend.mappers.CardMapper;
import com.carolina.backend.model.Board;
import com.carolina.backend.model.Card;
import com.carolina.backend.repositories.CardRepository;
import com.carolina.backend.services.CardService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final BoardServiceImpl boardService;

    @Override
    public List<CardResponseDTO> allCards(Long boardId) {
        Board board = boardService.findBoard(boardId);

        if (board == null) {
            throw new InvalidRequestException("Board ID is invalid.");
        }

        List<Card> cards = cardRepository.findByBoard(board);

        if (cards.isEmpty()) {
            throw new InvalidRequestException("No cards found for this board.");
        }

        return cards.stream().map(cardMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public CardResponseDTO saveCard(CardRequestDTO cardRequestDTO, Long boardId) {
        if (cardRequestDTO == null || cardRequestDTO.content() == null) {
            throw new InvalidRequestException("Invalid card data provided.");
        }
        Board board = boardService.findBoard(boardId);

        Card card = cardMapper.toCard(cardRequestDTO);
        card.setBoard(board);

        try {
            Card savedCard = cardRepository.save(card);

            return cardMapper.toResponseDTO(savedCard);
        } catch (Exception e) {
            throw new ServiceUnavailableException("Service is temporarily unavailable. Please try again later.");
        }
    }

    @Override
    public CardResponseDTO updateCard(Long id, CardRequestDTO cardRequestDTO) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found with ID: " + id));

        card.setContent(cardRequestDTO.content());
        card.setStatus(cardRequestDTO.status());

        Card updatedCard = cardRepository.save(card);

        return cardMapper.toResponseDTO(updatedCard);
    }

    @Override
    public void deleteCard(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card not found with ID: " + id));

        try {
            cardRepository.delete(card);
        } catch (Exception e) {
            throw new ServiceUnavailableException("Service is temporarily unavailable. Please try again later.");
        }
    }
}
