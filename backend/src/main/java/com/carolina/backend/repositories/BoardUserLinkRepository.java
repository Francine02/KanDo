package com.carolina.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolina.backend.model.Board;
import com.carolina.backend.model.BoardUserLink;
import com.carolina.backend.model.User;

public interface BoardUserLinkRepository extends JpaRepository<BoardUserLink, Long> {
    boolean existsByBoardAndUser(Board board, User user);
    List<BoardUserLink> findByBoardId(Long boardId);
}
