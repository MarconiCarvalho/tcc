package com.faculdade.tcc.Repositories;

import com.faculdade.tcc.domain.resetPassword.TokenPassword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TokenPasswordRepository extends JpaRepository<TokenPassword, UUID> {
}
