package com.carolina.backend.mappers;

import org.mapstruct.Mapper;

import com.carolina.backend.dtos.response.BoardUserLinkResponseDTO;
import com.carolina.backend.model.BoardUserLink;

@Mapper(componentModel = "spring")
public interface BoardUserLinkMapper {
    // De entidade para dto
    BoardUserLinkResponseDTO toResponseDTO(BoardUserLink boardUserLink);
}
