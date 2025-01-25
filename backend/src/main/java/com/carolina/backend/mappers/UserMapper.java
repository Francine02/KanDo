package com.carolina.backend.mappers;

import org.mapstruct.Mapper;

import com.carolina.backend.dtos.response.UserInfoResponseDTO;
import com.carolina.backend.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // De entidade para dto
    UserInfoResponseDTO toResponseDTO(User user);
}
