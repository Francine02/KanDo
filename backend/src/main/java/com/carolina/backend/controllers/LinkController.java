package com.carolina.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carolina.backend.controllers.swagger.LinkControllerSwagger;
import com.carolina.backend.dtos.response.BoardResponseDTO;
import com.carolina.backend.dtos.response.LinkResponseDTO;
import com.carolina.backend.services.LinkService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/links")
@AllArgsConstructor
public class LinkController implements LinkControllerSwagger {
    private final LinkService linkService;

    @PostMapping("/generate/{boardId}")
    public ResponseEntity<LinkResponseDTO> generateLink(@PathVariable Long boardId) {
        LinkResponseDTO link = linkService.createLink(boardId);
        return ResponseEntity.ok(link);
    }

    @GetMapping("/board/{uuid}")
    public ResponseEntity<BoardResponseDTO> getBoardFromLink(@PathVariable String uuid, Authentication authentication) {
        BoardResponseDTO board = linkService.getBoardFromLink(uuid, authentication);
        return ResponseEntity.ok(board);
    }
}
