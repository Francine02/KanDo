package com.carolina.backend.controllers.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;

import com.carolina.backend.dtos.response.BoardResponseDTO;
import com.carolina.backend.dtos.response.LinkResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Link", description = "Endpoint to manage Links")
public interface LinkControllerSwagger {
    @Operation(summary = "Generates a link associated with a board", description = "Generates a link for the provided board ID and associates it with the authenticated user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Link generated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = LinkResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Board not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    ResponseEntity<LinkResponseDTO> generateLink(@PathVariable Long boardId);

    @Operation(summary = "Retrieves a board from a link", description = "Fetches a board using its associated link UUID and returns the board details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Board retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BoardResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Link not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    ResponseEntity<BoardResponseDTO> getBoardFromLink(@PathVariable String uuid, Authentication authentication);
}
