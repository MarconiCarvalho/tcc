package com.faculdade.tcc.domain.dtos;

import com.faculdade.tcc.domain.user.UserType;

public record UserDTO(String name, String email, String matricula, UserType role) {
}
