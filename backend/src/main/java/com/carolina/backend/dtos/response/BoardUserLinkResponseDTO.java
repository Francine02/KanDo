package com.carolina.backend.dtos.response;

import com.carolina.backend.model.Board;
import com.carolina.backend.model.User;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "BoardUserLink information")
public record BoardUserLinkResponseDTO(
                Long id,
                Board board,
                User user) {
}
