package com.faculdade.tcc.domain.dtos;

import com.faculdade.tcc.domain.answers.OptionAnswers;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.user.User;

public record AnswersDTO(OptionAnswers option, Question idQuestion, User idUser) {
}
