package com.faculdade.tcc.Repositories;

import com.faculdade.tcc.EmailPassword.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
