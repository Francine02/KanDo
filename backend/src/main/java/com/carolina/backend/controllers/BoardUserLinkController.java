package com.carolina.backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolina.backend.controllers.swagger.BoardUserLinkControllerSwagger;
import com.carolina.backend.dtos.response.BoardUserLinkResponseDTO;
import com.carolina.backend.services.BoardUserLinkService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/board-users")
@AllArgsConstructor
public class BoardUserLinkController implements BoardUserLinkControllerSwagger {

    private final BoardUserLinkService boardUserLinkService;

    @GetMapping("/{boardId}")
    public ResponseEntity<List<BoardUserLinkResponseDTO>> getBoardUsers(@PathVariable Long boardId) {
        List<BoardUserLinkResponseDTO> boardUsers = boardUserLinkService.getBoardUsers(boardId);
        return ResponseEntity.ok(boardUsers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoardUserLink(@PathVariable Long id) {
        boardUserLinkService.deleteBoardUserLink(id);
        return ResponseEntity.noContent().build();
    }
}
