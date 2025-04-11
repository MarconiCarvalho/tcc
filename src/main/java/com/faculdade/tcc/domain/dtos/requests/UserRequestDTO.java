package com.faculdade.tcc.domain.dtos.requests;

import com.faculdade.tcc.domain.user.UserType;

public record UserRequestDTO(String name, String email, String matricula, UserType role) {
}
