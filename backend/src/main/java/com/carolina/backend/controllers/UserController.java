package com.carolina.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.carolina.backend.controllers.swagger.UserControllerSwagger;
import com.carolina.backend.dtos.response.UserInfoResponseDTO;
import com.carolina.backend.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController implements UserControllerSwagger {

    private final UserService userService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<UserInfoResponseDTO> getUserInfo(Authentication authentication) {
        UserInfoResponseDTO userInfoResponseDTO = userService.info(authentication);
        return ResponseEntity.ok(userInfoResponseDTO);
    }

}
