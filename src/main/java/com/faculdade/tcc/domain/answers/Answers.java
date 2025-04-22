package com.faculdade.tcc.domain.answers;

import com.faculdade.tcc.domain.dtos.requests.AnswersRequestDTO;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "ANSWERS_TABLE")
@Table(name = "ANSWERS_TABLE")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Answers implements Serializable {

    @Serial
    private static final long serialVersionID = 1L;

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
    public Answers(){

    }

    public UUID getId() {
        return id;
    }

    public OptionAnswers getOption() {
        return option;
    }

    public void setOption(OptionAnswers option) {
        this.option = option;
    }

    public Question getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Question idQuestion) {
        this.idQuestion = idQuestion;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

}
