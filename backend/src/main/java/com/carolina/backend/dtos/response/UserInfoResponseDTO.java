package com.carolina.backend.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User information")
public record UserInfoResponseDTO(
        String name,
        String email,
        String image) {}
