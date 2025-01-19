package com.carolina.backend.dtos.response;

public record ErrorResponseDTO(
        String errorCode,
        String message) {}
