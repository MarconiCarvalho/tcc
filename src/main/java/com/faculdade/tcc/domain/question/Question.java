package com.faculdade.tcc.domain.question;

import com.faculdade.tcc.domain.dtos.QuestionDTO;
import com.faculdade.tcc.domain.questionnaire.Questionnarie;
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
    private Questionnarie idQuestionnaire;
    private String description;
    private Integer ordem;

    public Question(QuestionDTO data){
        this.idQuestionnaire = data.idQuestionnaire();
        this.description = data.description();
        this.ordem = data.ordem();
    }
}
