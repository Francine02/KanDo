package com.carolina.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolina.backend.model.BoardUserLink;

public interface BoardUserLinkRepository extends JpaRepository<BoardUserLink, Long> {

}
