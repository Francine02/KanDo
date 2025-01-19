package com.carolina.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolina.backend.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}