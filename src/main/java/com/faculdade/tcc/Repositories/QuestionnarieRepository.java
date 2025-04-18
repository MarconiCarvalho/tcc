package com.faculdade.tcc.Repositories;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnarieRepository extends JpaRepository<Questionnaire, Long> {
}
