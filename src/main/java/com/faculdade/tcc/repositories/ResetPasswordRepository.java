package com.faculdade.tcc.repositories;

import com.faculdade.tcc.domain.resetPassword.ResetPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResetPasswordRepository extends JpaRepository<ResetPassword, UUID> {

    ResetPassword findByToken(String token);
}
