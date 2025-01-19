package com.carolina.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carolina.backend.model.Link;

public interface LinkRepository extends JpaRepository<Link, String> {

}
