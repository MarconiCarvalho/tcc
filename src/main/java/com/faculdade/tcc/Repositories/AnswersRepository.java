package com.faculdade.tcc.Repositories;

import com.faculdade.tcc.domain.answers.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepository extends JpaRepository<Answers, Long> {
}
