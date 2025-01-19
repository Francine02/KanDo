package com.carolina.backend.service;

import org.springframework.security.core.Authentication;

import com.carolina.backend.dtos.response.UserInfoResponseDTO;

public interface UserService {
    UserInfoResponseDTO info(Authentication authentication);
}
