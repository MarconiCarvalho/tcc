package com.faculdade.tcc.domain.questionnaire;

import com.faculdade.tcc.domain.dtos.requests.QuestionnaireRequestDTO;
import com.faculdade.tcc.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "QUESTIONNAIRE_TABLE")
@Table(name = "QUESTIONNAIRE_TABLE")
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Questionnaire implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String description;
    @Column(name = "CreatorUserId ")
    private UUID createBy;
    private LocalDateTime createAt;
    @Column(name = "UpdaterUserId")
    private UUID updateBy;
    private LocalDateTime updateAt;

    public Questionnaire(QuestionnaireRequestDTO data ){
        this.title = data.title();
        this.description = data.description();
    }
    public Questionnaire(){}

    public UUID getId() {
        return id;
    }

    public UUID getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UUID createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public UUID getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(UUID updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
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


}
