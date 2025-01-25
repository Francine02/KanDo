package com.carolina.backend.services;

import java.util.List;

import com.carolina.backend.dtos.request.CardRequestDTO;
import com.carolina.backend.dtos.response.CardResponseDTO;

public interface CardService {
    List<CardResponseDTO> allCards(Long boardId);

    CardResponseDTO saveCard(CardRequestDTO cardRequestDTO, Long boardId);

    CardResponseDTO updateCard(Long id, CardRequestDTO cardRequestDTO);

    void deleteCard(Long id);
}
