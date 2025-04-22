package com.faculdade.tcc.domain.dtos.requests;

import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.domain.user.UserType;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserRequestDTO(String name, String email, String registration, UUID createBy, UUID updateBy, UserType role) {
}
