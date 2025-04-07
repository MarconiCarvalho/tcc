package com.faculdade.tcc.question;

import com.faculdade.tcc.answers.AnswersType;
import com.faculdade.tcc.models.user.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "QUESTION_TABLE")
@Table(name = "QUESTION_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;

    private AnswersType response;
}
