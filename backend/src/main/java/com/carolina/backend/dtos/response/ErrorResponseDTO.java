package com.carolina.backend.dtos.response;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Error - code and message")
public record ErrorResponseDTO(
        HttpStatus errorCode,
        String message) {}
