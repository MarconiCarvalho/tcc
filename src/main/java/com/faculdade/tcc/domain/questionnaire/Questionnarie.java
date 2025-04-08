package com.faculdade.tcc.domain.questionnaire;

import com.faculdade.tcc.domain.dtos.QuestionnarieDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "QUESTIONNAIRE_TABLE")
@Table(name = "QUESTIONNAIRE_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questionnarie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;

    public Questionnarie(QuestionnarieDTO data ){
        this.title = data.title();
        this.description = data.description();
        this.creationDate = data.creationDate();
    }
}
