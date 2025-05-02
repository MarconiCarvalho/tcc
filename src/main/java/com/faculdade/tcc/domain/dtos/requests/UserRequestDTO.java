package com.faculdade.tcc.domain.dtos.requests;

import com.faculdade.tcc.domain.user.UserType;

import java.util.UUID;

public record UserRequestDTO(String name, String email, String registration,String password, UUID createBy,UUID updateBy, UserType role) {
}
