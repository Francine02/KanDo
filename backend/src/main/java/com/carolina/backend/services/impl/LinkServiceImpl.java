package com.carolina.backend.services.impl;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.carolina.backend.dtos.response.BoardResponseDTO;
import com.carolina.backend.dtos.response.LinkResponseDTO;
import com.carolina.backend.exceptions.InvalidRequestException;
import com.carolina.backend.exceptions.ResourceNotFoundException;
import com.carolina.backend.mappers.BoardMapper;
import com.carolina.backend.mappers.LinkMapper;
import com.carolina.backend.model.Board;
import com.carolina.backend.model.BoardUserLink;
import com.carolina.backend.model.Link;
import com.carolina.backend.model.User;
import com.carolina.backend.repositories.BoardUserLinkRepository;
import com.carolina.backend.repositories.LinkRepository;
import com.carolina.backend.services.LinkService;
import com.carolina.backend.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;
    private final BoardServiceImpl boardService;
    private final LinkMapper linkMapper;
    private final BoardMapper boardMapper;
    private final UserService userService;
    private final BoardUserLinkRepository boardUserLinkRepository;

    @Override
    public LinkResponseDTO createLink(Long id) {
        Board board = boardService.findBoard(id);

        if (board == null) {
            throw new InvalidRequestException("Board ID is invalid.");
        }

        Link link = new Link();
        link.setBoard(board);

        Link savedLink = linkRepository.save(link);

        return linkMapper.toResponseDTO(savedLink);
    }

    @Override
    public BoardResponseDTO getBoardFromLink(String uuid, Authentication authentication) {
        User user = userService.getUser(authentication);

        Link link = linkRepository.findByUuid(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Board not found for UUID: " + uuid));

        Board board = link.getBoard();

        boolean userAlreadyAdded = boardUserLinkRepository.existsByBoardAndUser(board, user);
        if (!userAlreadyAdded) {
            BoardUserLink boardUserLink = new BoardUserLink();
            boardUserLink.setBoard(board);
            boardUserLink.setUser(user);
            boardUserLinkRepository.save(boardUserLink);
        }

        return boardMapper.toResponseDTO(board);
    }

}
