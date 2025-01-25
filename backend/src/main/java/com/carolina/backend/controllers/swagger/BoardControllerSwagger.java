package com.carolina.backend.controllers.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.carolina.backend.dtos.request.BoardRequestDTO;
import com.carolina.backend.dtos.response.BoardResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Board", description = "Endpoint to manage boards")
public interface BoardControllerSwagger {
    @Operation(summary = "Retrieve all boards for the authenticated user", description = "Returns a list of all boards associated with the authenticated user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of boards retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BoardResponseDTO.class)))
    })
    ResponseEntity<List<BoardResponseDTO>> getBoards(Authentication authentication);

    @Operation(summary = "Retrieve a specific board by ID", description = "Returns details of a specific board if the user has access.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Board retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BoardResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Board not found", content = @Content)
    })
    ResponseEntity<BoardResponseDTO> getBoardId(Authentication authentication, @PathVariable Long id);

    @Operation(summary = "Create a new board", description = "Creates a new board associated with the authenticated user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Board created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BoardResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data", content = @Content)
    })
    ResponseEntity<BoardResponseDTO> saveBoard(
            Authentication authentication,
            @RequestBody BoardRequestDTO boardRequestDTO);

    @Operation(summary = "Delete a board by ID", description = "Deletes a specific board if the user has access.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Board deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Board not found or unauthorized access", content = @Content)
    })
    ResponseEntity<Void> deleteBoard(Authentication authentication, @PathVariable Long id);
}