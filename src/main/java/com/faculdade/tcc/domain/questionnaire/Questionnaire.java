package com.faculdade.tcc.domain.questionnaire;

import com.faculdade.tcc.domain.dtos.requests.QuestionnaireRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "QUESTIONNAIRE_TABLE")
@Table(name = "QUESTIONNAIRE_TABLE")
@Setter
@AllArgsConstructor
public class Questionnaire implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    private LocalDateTime creationDate;

    public Questionnaire(QuestionnaireRequestDTO data ){
        this.title = data.title();
        this.description = data.description();
        this.creationDate = data.creationDate();
    }
    public Questionnaire(){}

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

}
