package com.carolina.backend.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.carolina.backend.dtos.request.BoardRequestDTO;
import com.carolina.backend.dtos.response.BoardResponseDTO;
import com.carolina.backend.exceptions.InvalidAuthenticationException;
import com.carolina.backend.exceptions.InvalidRequestException;
import com.carolina.backend.exceptions.ResourceNotFoundException;
import com.carolina.backend.mappers.BoardMapper;
import com.carolina.backend.model.Board;
import com.carolina.backend.model.User;
import com.carolina.backend.repositories.BoardRepository;
import com.carolina.backend.services.BoardService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;
    private final UserServiceImpl userServiceImpl;

    @Override
    public List<BoardResponseDTO> allBoards(Authentication authentication) {
        User user = userServiceImpl.getUser(authentication);

        List<Board> boards = boardRepository.findByUser(user);

        if (boards.isEmpty()) {
            throw new InvalidRequestException("No boards found for this user.");
        }

        return boards.stream()
                .map(boardMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BoardResponseDTO boardId(Long id, Authentication authentication) {
        User user = userServiceImpl.getUser(authentication);

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board not found with ID: " + id));

        if (!board.getUser().equals(user)) {
            throw new InvalidAuthenticationException("User is not authorized");
        }

        return boardMapper.toResponseDTO(board);
    }

    @Override
    public BoardResponseDTO saveBoard(BoardRequestDTO requestDTO, Authentication authentication) {
        Board board = boardMapper.toBoard(requestDTO);

        if (board == null || requestDTO == null) {
            throw new InvalidRequestException("Invalid board data provided.");
        }

        userToBoard(board, authentication);

        Board savedBoard = boardRepository.save(board);

        return boardMapper.toResponseDTO(savedBoard);
    }

    @Override
    public void deleteBoard(Long id, Authentication authentication) {
        User user = userServiceImpl.getUser(authentication);

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Board not found with ID: " + id));

        if (!board.getUser().equals(user)) {
            throw new InvalidAuthenticationException("User is not authorized to delete this board.");
        }

        boardRepository.delete(board);
    }

    private void userToBoard(Board board, Authentication authentication) {
        User user = userServiceImpl.getUser(authentication);
        board.setUser(user);
    }

    public Board findBoard(Long boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new ResourceNotFoundException("Board not found with ID: " + boardId));
    }
}
