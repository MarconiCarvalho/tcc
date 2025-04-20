package com.faculdade.tcc.Repositories;

import com.faculdade.tcc.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<Object> findById(UUID id);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
