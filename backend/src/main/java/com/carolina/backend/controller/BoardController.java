package com.carolina.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolina.backend.dtos.request.BoardRequestDTO;
import com.carolina.backend.dtos.response.BoardResponseDTO;
import com.carolina.backend.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/boards")
@RestController
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardResponseDTO>> getBoards(Authentication authentication) {
        List<BoardResponseDTO> boards = boardService.allBoards(authentication);

        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDTO> getBoardId(Authentication authentication, @PathVariable Long id) {
        BoardResponseDTO boardId = boardService.boardId(id, authentication);

        return ResponseEntity.ok(boardId);
    }

    @PostMapping("/create-board")
    public ResponseEntity<BoardResponseDTO> saveBoard(Authentication authentication, @RequestBody BoardRequestDTO boardRequestDTO) {
        BoardResponseDTO board = boardService.saveBoard(boardRequestDTO, authentication);

        return ResponseEntity.status(201).body(board);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BoardResponseDTO> deleteBoard(Authentication authentication, @PathVariable Long id) {
        boardService.deleteBoard(id, authentication);

        return ResponseEntity.noContent().build();
    }
}
