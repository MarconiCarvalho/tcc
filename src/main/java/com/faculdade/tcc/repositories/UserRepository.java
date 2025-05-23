package com.faculdade.tcc.repositories;

import com.faculdade.tcc.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<UserDetails> findByEmail(String email);


    Optional<User> findById(UUID id);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
