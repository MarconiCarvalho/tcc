package com.faculdade.tcc.repositories;

import com.faculdade.tcc.controllers.ResetPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ResetPasswordRepository extends JpaRepository<ResetPassword, UUID> {

    ResetPassword findByToken(String token);
}
