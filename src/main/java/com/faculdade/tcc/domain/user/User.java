package com.faculdade.tcc.domain.user;

import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity(name = "USER_TABLE")
@Table(name = "USER_TABLE")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotBlank(message = "o nome é obrigatório")
    private String name;
    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String registration;
    @ManyToOne
    @JoinColumn(name = "CreatorUserId")
    private User createBy;
    private LocalDateTime createAt;
    @ManyToOne
    @JoinColumn(name = "UpdaterUserId")
    private User updateBy;
    private LocalDateTime updateAt;
    @Enumerated(EnumType.STRING)
    private UserType role ;

    public User(UserRequestDTO data){
        this.name = data.name();
        this.email = data.email();
        this.registration = data.registration();
        this.role = data.role();
    }

    public User(){}

    public UUID getId(){
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdateBy(User updateBy){
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
    public User getUpdateBy() {
        return updateBy;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public User getCreateBy() {
        return createBy;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }



}
