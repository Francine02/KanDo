package com.carolina.backend.controllers.swagger;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import com.carolina.backend.dtos.response.UserInfoResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User", description = "Endpoint to get user information")
public interface UserControllerSwagger {
    @Operation(summary = "Get authenticated user information via OAuth2", description = "Returns the user's data including name, email and image based on Google login. First access this url to login with google to be authorized -> http://localhost:8080/login/oauth2/code/google or https://kando-gf9l.onrender.com/login/oauth2/code/google")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User information retrieved successfully",  content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserInfoResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid authentication or bad request", content = @Content),
            @ApiResponse(responseCode = "404", description = "User not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    ResponseEntity<UserInfoResponseDTO> getUserInfo(
            @Parameter(description = "Authentication information of the authenticated user") Authentication authentication);
}