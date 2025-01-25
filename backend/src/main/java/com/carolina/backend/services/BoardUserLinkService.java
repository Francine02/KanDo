package com.carolina.backend.services;

import java.util.List;

import com.carolina.backend.dtos.response.BoardUserLinkResponseDTO;

public interface BoardUserLinkService {
    List<BoardUserLinkResponseDTO> getBoardUsers(Long boardId);

    void deleteBoardUserLink(Long id);
}
