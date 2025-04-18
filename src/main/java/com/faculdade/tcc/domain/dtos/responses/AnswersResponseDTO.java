package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.answers.Answers;
import com.faculdade.tcc.domain.answers.OptionAnswers;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.user.User;

public record AnswersResponseDTO(OptionAnswers option, Question idQuestion, User idUser){
    public AnswersResponseDTO(Answers answers){
        this(answers.getOption(), answers.getIdQuestion(), answers.getIdUser());
    }
}
