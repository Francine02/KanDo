package com.carolina.backend.dtos.request;

import com.carolina.backend.enums.Status;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record CardRequestDTO(
        @Schema(description = "Card content", example = "Terminar o login do KanDo", maxLength = 300, required = true) @NotBlank(message = "Card content is required") String content,

        @Schema(description = "The status of the task", allowableValues = {
                "TO_DO", "DOING",
                "DONE" }, example = "DONE", required = true) @NotBlank(message = "Status is required") Status status){

}
