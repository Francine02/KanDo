package com.carolina.backend.controllers.swagger;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.carolina.backend.dtos.response.BoardUserLinkResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@Tag(name = "Board User Link", description = "Endpoint to manage Board User Links")
public interface BoardUserLinkControllerSwagger {

    @Operation(summary = "Deletes a user link from a board", description = "Deletes the link of a user from the specified board.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User link deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Link not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content)
    })
    ResponseEntity<Void> deleteBoardUserLink(@PathVariable Long id);

    @Operation(summary = "Fetches all users linked to a board", description = "Returns a list of all users linked to the specified board.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of board users retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = BoardUserLinkResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Board not found", content = @Content)
    })
    ResponseEntity<List<BoardUserLinkResponseDTO>> getBoardUsers(@PathVariable Long boardId);
}
