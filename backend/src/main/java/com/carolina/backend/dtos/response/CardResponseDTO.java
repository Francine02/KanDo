package com.carolina.backend.dtos.response;

import com.carolina.backend.enums.Status;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Card information")
public record CardResponseDTO(
        Long id,
        String content,
        Status status) {}
