package com.faculdade.tcc.domain.dtos.requests;

import com.faculdade.tcc.domain.answers.OptionAnswers;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record AnswersRequestDTO(OptionAnswers option, UUID idQuestion, UUID idUser, UUID createBy, UUID updateBy, LocalDateTime createAt, LocalDateTime updateAt) {
}
