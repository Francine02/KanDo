package com.carolina.backend.dtos.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BoardRequestDTO(
                @Schema(description = "Name of the Board", example = "Estudos", maxLength = 100, required = true) @NotBlank(message = "Board name is required") @Size(max = 30) String name) {
}
