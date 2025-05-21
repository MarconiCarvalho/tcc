package com.faculdade.tcc.repositories;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionnaireRepository extends JpaRepository<Questionnaire, UUID> {
    Optional<Questionnaire> findById(UUID id);

    void deleteById(UUID id);

    boolean existsById(UUID id);
}
