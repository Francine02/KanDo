package com.carolina.backend.dtos.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Link generated")
public record LinkResponseDTO(
    String uuid
) {}
