package com.faculdade.tcc.domain.questionnaire;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "QUESTIONNAIRE_TABLE")
@Table(name = "QUESTIONNAIRE_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String creationDate;
}
