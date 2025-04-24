package com.faculdade.tcc.Repositories;

import com.faculdade.tcc.domain.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID>{

    Optional<Question> findById(UUID id);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
