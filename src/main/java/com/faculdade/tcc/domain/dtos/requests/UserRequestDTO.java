package com.faculdade.tcc.domain.dtos.requests;

import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.domain.user.UserType;

import java.time.LocalDateTime;

public record UserRequestDTO(String name, String email, String registration, User createBy, LocalDateTime createAt, User updateBy, LocalDateTime updateAt, UserType role) {
}
