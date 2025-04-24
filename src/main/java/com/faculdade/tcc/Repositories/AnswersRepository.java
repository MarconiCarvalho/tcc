package com.faculdade.tcc.Repositories;

import com.faculdade.tcc.domain.answers.Answers;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AnswersRepository extends JpaRepository<Answers, UUID> {
    Optional<Answers> findById(UUID id);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
