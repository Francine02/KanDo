package com.carolina.backend.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.carolina.backend.dtos.response.BoardUserLinkResponseDTO;
import com.carolina.backend.exceptions.ResourceNotFoundException;
import com.carolina.backend.mappers.BoardUserLinkMapper;
import com.carolina.backend.model.BoardUserLink;
import com.carolina.backend.repositories.BoardUserLinkRepository;
import com.carolina.backend.services.BoardUserLinkService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardUserLinkServiceImpl implements BoardUserLinkService {

    private final BoardUserLinkRepository boardUserLinkRepository;
    private final BoardUserLinkMapper boardUserLinkMapper;

    @Override
    public List<BoardUserLinkResponseDTO> getBoardUsers(Long boardId) {
        List<BoardUserLink> boardUserLinks = boardUserLinkRepository.findByBoardId(boardId);

        return boardUserLinks.stream().map(boardUserLinkMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteBoardUserLink(Long id) {
        BoardUserLink boardUserLink = boardUserLinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board with link not found!"));
        boardUserLinkRepository.delete(boardUserLink);
    }

}
