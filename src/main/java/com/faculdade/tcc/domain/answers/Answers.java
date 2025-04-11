package com.faculdade.tcc.domain.answers;

import com.faculdade.tcc.domain.dtos.requests.AnswersRequestDTO;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "ANSWERS_TABLE")
@Table(name = "ANSWERS_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answers implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private OptionAnswers option;
    @ManyToOne
    @JoinColumn(name = "ID_QUESTION")
    private Question idQuestion;
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User idUser;

    public Answers(AnswersRequestDTO data){
        this.option = data.option();
        this.idQuestion = data.idQuestion();
        this.idUser = data.idUser();
    }
}
