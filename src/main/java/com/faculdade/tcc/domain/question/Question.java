package com.faculdade.tcc.domain.question;

import com.faculdade.tcc.domain.questionnaire.Questionnaire;
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
    @ManyToOne
    @JoinColumn(name = "ID_QUESTIONNAIRE")
    private Questionnaire idQuestionnaire;
    private String description;
    private Integer ordem;
}
