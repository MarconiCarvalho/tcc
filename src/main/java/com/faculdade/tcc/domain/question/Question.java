package com.faculdade.tcc.domain.question;

import com.faculdade.tcc.domain.dtos.requests.QuestionRequestDTO;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
@Setter
@Entity(name = "QUESTION_TABLE")
@Table(name = "QUESTION_TABLE")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
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
    private Integer idOrder;

    public Question(QuestionRequestDTO data){
        this.idQuestionnaire = data.idQuestionnaire();
        this.description = data.description();
        this.idOrder = data.idOrder();
    }

    public Question(){}


    public UUID getId() {
        return id;
    }

    public Questionnaire getIdQuestionnaire() {
        return idQuestionnaire;
    }



    public String getDescription() {
        return description;
    }


    public Integer getOrder() {
        return idOrder;
    }

}
