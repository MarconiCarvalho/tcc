package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.domain.user.UserType;

import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String registration, UserType role) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getRegistration(), user.getRole());
    }


}
