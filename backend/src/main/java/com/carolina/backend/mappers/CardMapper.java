package com.carolina.backend.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.carolina.backend.dtos.request.CardRequestDTO;
import com.carolina.backend.dtos.response.CardResponseDTO;
import com.carolina.backend.model.Card;

@Mapper(componentModel = "spring")
public interface CardMapper {
    // De dto para entidade
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "board", ignore = true)
    Card toCard(CardRequestDTO cardRequestDTO);

    // De entidade para dto
    CardResponseDTO toResponseDTO(Card card);
}
