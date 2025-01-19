package com.carolina.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolina.backend.model.Board;
import com.carolina.backend.model.User;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByUser(User user);
}