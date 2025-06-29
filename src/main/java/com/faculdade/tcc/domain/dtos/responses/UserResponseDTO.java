package com.faculdade.tcc.domain.dtos.responses;
import com.faculdade.tcc.domain.user.User;
import com.faculdade.tcc.domain.user.UserType;
import java.time.LocalDateTime;
import java.util.UUID;

public record UserResponseDTO(UUID id, String name, String email, String registration, String password, UUID createBy, LocalDateTime createAt, UUID updateBy, LocalDateTime updateAt, UserType role) {
    public UserResponseDTO(User user){
        this(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRegistration(),
                user.getPassword(),
                user.getCreateBy(),
                user.getCreateAt(),
                user.getUpdateBy(),
                user.getUpdateAt(),
                user.getRole());
    }


}
