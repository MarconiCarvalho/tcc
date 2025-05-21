package com.faculdade.tcc.repositories;

import com.faculdade.tcc.domain.email.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
