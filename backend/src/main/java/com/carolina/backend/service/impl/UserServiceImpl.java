package com.carolina.backend.service.impl;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.carolina.backend.dtos.response.UserInfoResponseDTO;
import com.carolina.backend.mapper.UserMapper;
import com.carolina.backend.model.User;
import com.carolina.backend.repositories.UserRepository;
import com.carolina.backend.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserInfoResponseDTO info(Authentication authentication) {
        User user = getUser(authentication);
        return userMapper.toResponseDTO(user);
    }

    public User getUser(Authentication authentication) {
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        Map<String, Object> attributes = oauthToken.getPrincipal().getAttributes();

        String name = (String) attributes.get("name");
        String email = (String) attributes.get("email");
        String image = (String) attributes.get("picture");

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> createNewUser(name, email, image));

        updateUserIfNeeded(user, name, image);

        return user;
    }

    private User createNewUser(String name, String email, String image) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setImage(image);
        return userRepository.save(newUser);
    }

    private void updateUserIfNeeded(User user, String name, String image) {
        boolean needsUpdate = !user.getName().equals(name) || !user.getImage().equals(image);

        if (needsUpdate) {
            user.setName(name);
            user.setImage(image);
            userRepository.save(user);
        }
    }
}
