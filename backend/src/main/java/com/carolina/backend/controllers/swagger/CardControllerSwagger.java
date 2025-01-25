package com.carolina.backend.controllers.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.carolina.backend.dtos.request.CardRequestDTO;
import com.carolina.backend.dtos.response.CardResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Card Controller", description = "Endpoints for managing cards associated with boards")
public interface CardControllerSwagger {

    @Operation(summary = "Retrieve all cards for a specific board", description = "Fetches all cards associated with the given board ID.", responses = {
            @ApiResponse(responseCode = "200", description = "List of cards retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Board not found")
    })
    ResponseEntity<List<CardResponseDTO>> allCards(
            @Parameter(description = "ID of the board whose cards are to be retrieved", required = true) @PathVariable Long boardId);

    @Operation(summary = "Create a new card for a specific board", description = "Creates a new card and associates it with the given board ID.", responses = {
            @ApiResponse(responseCode = "201", description = "Card created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Board not found")
    })
    ResponseEntity<CardResponseDTO> createCard(
            @Parameter(description = "Details of the card to be created", required = true) @RequestBody CardRequestDTO cardRequestDTO,
            @Parameter(description = "ID of the board where the card will be added", required = true) @PathVariable Long boardId);

    @Operation(summary = "Update an existing card", description = "Updates the details of an existing card identified by its ID.", responses = {
            @ApiResponse(responseCode = "200", description = "Card updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CardResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Card not found")
    })
    ResponseEntity<CardResponseDTO> updateCard(
            @Parameter(description = "Details of the card to be updated", required = true) @RequestBody CardRequestDTO cardRequestDTO,
            @Parameter(description = "ID of the card to be updated", required = true) @PathVariable Long id);

    @Operation(summary = "Delete a card", description = "Deletes an existing card identified by its ID.", responses = {
            @ApiResponse(responseCode = "204", description = "Card deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Card not found")
    })
    ResponseEntity<Void> deleteCard(
            @Parameter(description = "ID of the card to be deleted", required = true) @PathVariable Long id);
}
