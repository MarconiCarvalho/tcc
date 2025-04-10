package com.faculdade.tcc.domain.responses;

import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.domain.user.UserType;

public record UserResponseDTO(Long id, String name, String email, String matricula, UserType role) {
    public UserResponseDTO(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getMatricula(), user.getRole());
    }

}
