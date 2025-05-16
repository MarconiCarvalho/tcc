package com.faculdade.tcc.Repositories;

import com.faculdade.tcc.EmailPassword.domain.ResetPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResetPasswordRepository extends JpaRepository<ResetPassword, UUID> {

    ResetPassword findByToken(String token);
}
