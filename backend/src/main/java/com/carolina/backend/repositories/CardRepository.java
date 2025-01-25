package com.carolina.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolina.backend.model.Board;
import com.carolina.backend.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByBoard(Board board);
}
