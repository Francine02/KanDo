package com.carolina.backend.mappers;

import org.mapstruct.Mapper;

import com.carolina.backend.dtos.response.LinkResponseDTO;
import com.carolina.backend.model.Link;

@Mapper(componentModel = "spring")
public interface LinkMapper {
    // De entidade para dto
    LinkResponseDTO toResponseDTO(Link link);
}
