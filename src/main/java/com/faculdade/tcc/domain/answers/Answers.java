package com.faculdade.tcc.domain.answers;

import com.faculdade.tcc.domain.dtos.requests.AnswersRequestDTO;
import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    @Column(name = "ID_QUESTION")
    private UUID idQuestion;
    @Column(name = "ID_USER")
    private UUID idUser;
    private UUID createBy;
    private UUID updateBy;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Answers(AnswersRequestDTO data){
        this.option = data.option();
        this.idQuestion = data.idQuestion();
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
    public UUID getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UUID createBy) {
        this.createBy = createBy;
    }

    public UUID getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(UUID updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }


    public UUID getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(UUID idQuestion) {
        this.idQuestion = idQuestion;
    }

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

}
