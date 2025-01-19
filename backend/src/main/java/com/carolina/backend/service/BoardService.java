package com.carolina.backend.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.carolina.backend.dtos.request.BoardRequestDTO;
import com.carolina.backend.dtos.response.BoardResponseDTO;

public interface BoardService {
    List<BoardResponseDTO> allBoards(Authentication authentication);

    BoardResponseDTO boardId(Long id, Authentication authentication);

    BoardResponseDTO saveBoard(BoardRequestDTO requestDTO, Authentication authentication);

    void deleteBoard(Long id, Authentication authentication);
}
