package com.carolina.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.carolina.backend.dtos.request.BoardRequestDTO;
import com.carolina.backend.dtos.response.BoardResponseDTO;
import com.carolina.backend.model.Board;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    // De dto para entidade
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cards", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "boardUsers", ignore = true)
    Board toBoard(BoardRequestDTO boardRequestDTO);

    // De entidade para dto
    BoardResponseDTO toResponseDTO(Board board);
}