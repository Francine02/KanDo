package com.carolina.backend.services;

import org.springframework.security.core.Authentication;

import com.carolina.backend.dtos.response.BoardResponseDTO;
import com.carolina.backend.dtos.response.LinkResponseDTO;

public interface LinkService {
    LinkResponseDTO createLink(Long id);

    BoardResponseDTO getBoardFromLink(String uuid, Authentication authentication);
}
