package com.carolina.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolina.backend.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
