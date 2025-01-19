package com.carolina.backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.carolina.backend.dtos.request.BoardRequestDTO;
import com.carolina.backend.dtos.response.BoardResponseDTO;
import com.carolina.backend.exceptions.BoardNotFoundException;
import com.carolina.backend.mapper.BoardMapper;
import com.carolina.backend.model.Board;
import com.carolina.backend.model.User;
import com.carolina.backend.repositories.BoardRepository;
import com.carolina.backend.service.BoardService;

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

        return boards.stream()
                .map(boardMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BoardResponseDTO boardId(Long id, Authentication authentication) {
        User user = userServiceImpl.getUser(authentication);

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException("Board not found!", null));

        if (!board.getUser().equals(user)) {
            throw new BoardNotFoundException("Unauthorized access to the board", null);
        }

        return boardMapper.toResponseDTO(board);
    }

    @Override
    public BoardResponseDTO saveBoard(BoardRequestDTO requestDTO, Authentication authentication) {
        Board board = boardMapper.toBoard(requestDTO);

        userToBoard(board, authentication);

        Board savedBoard = boardRepository.save(board);

        return boardMapper.toResponseDTO(savedBoard);
    }

    @Override
    public void deleteBoard(Long id, Authentication authentication) {
        User user = userServiceImpl.getUser(authentication);

        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException("Board not found!", null));

        if (!board.getUser().equals(user)) {
            throw new BoardNotFoundException("Unauthorized to delete the board", null);
        }

        boardRepository.delete(board);
    }

    private void userToBoard(Board board, Authentication authentication) {
        User user = userServiceImpl.getUser(authentication);
        board.setUser(user);
    }

}
