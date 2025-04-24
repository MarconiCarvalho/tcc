package com.faculdade.tcc.domain.dtos.responses;

import com.faculdade.tcc.domain.answers.Answers;
import com.faculdade.tcc.domain.answers.OptionAnswers;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record AnswersResponseDTO(OptionAnswers option, UUID idQuestion, UUID idUser, UUID createBy, LocalDateTime createAt, UUID updateBy, LocalDateTime updateAt){
    public AnswersResponseDTO(Answers answers){
        this(answers.getOption(), answers.getIdQuestion(), answers.getIdUser(), answers.getCreateBy(), answers.getCreateAt(),answers.getUpdateBy(),answers.getUpdateAt());
    }
}
