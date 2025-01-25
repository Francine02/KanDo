package com.carolina.backend.services;

import org.springframework.security.core.Authentication;

import com.carolina.backend.dtos.response.UserInfoResponseDTO;
import com.carolina.backend.model.User;

public interface UserService {
    UserInfoResponseDTO info(Authentication authentication);

    User getUser(Authentication authentication);
}
