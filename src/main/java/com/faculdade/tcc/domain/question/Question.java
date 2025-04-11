package com.faculdade.tcc.domain.question;

import com.faculdade.tcc.domain.dtos.requests.QuestionRequestDTO;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "QUESTION_TABLE")
@Table(name = "QUESTION_TABLE")
@AllArgsConstructor
public class Question implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "ID_QUESTIONNAIRE")
    private Questionnaire idQuestionnaire;
    private String description;
    private Integer order;

    public Question(QuestionRequestDTO data){
        this.idQuestionnaire = data.idQuestionnaire();
        this.description = data.description();
        this.order = data.order();
    }

    public Question(){}


    public UUID getId() {
        return id;
    }

    public Questionnaire getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(Questionnaire idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrdem(Integer order) {
        this.order = order;
    }
}
