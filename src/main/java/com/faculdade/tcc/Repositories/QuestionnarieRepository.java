package com.faculdade.tcc.Repositories;

import com.faculdade.tcc.domain.questionnaire.Questionnarie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionnarieRepository extends JpaRepository<Questionnarie, Long> {
}
