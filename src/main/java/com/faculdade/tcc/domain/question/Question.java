package com.faculdade.tcc.domain.question;

import com.faculdade.tcc.domain.dtos.requests.QuestionRequestDTO;
import com.faculdade.tcc.domain.questionnaire.Questionnaire;
import com.faculdade.tcc.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
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
    @JoinColumn(name = "CreatorUserID")
    @ManyToOne
    private User createBy;
    private LocalDateTime createAt;
    @JoinColumn(name = "UpdaterUserId")
    @ManyToOne
    private User updateBy;
    private LocalDateTime updateAt;

    public Question(QuestionRequestDTO questionRequestDTO){
        this.description = questionRequestDTO.description();
        this.idOrder = questionRequestDTO.idOrder();
    }

    public Question(){}


    public UUID getId() {
        return id;
    }

    public Questionnaire getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setIdQuestionnaire(Questionnaire idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }


    public String getDescription() {
        return description;
    }


    public Integer getOrder() {
        return idOrder;
    }

}
