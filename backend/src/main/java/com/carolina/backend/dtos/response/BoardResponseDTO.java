package com.carolina.backend.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Board information")
public record BoardResponseDTO(
        Long id,
        String name) {
}