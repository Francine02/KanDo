package com.carolina.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolina.backend.model.Link;

public interface LinkRepository extends JpaRepository<Link, String> {
    Optional<Link> findByUuid(String uuid);
}
