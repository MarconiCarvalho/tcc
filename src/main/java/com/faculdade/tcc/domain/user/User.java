package com.faculdade.tcc.domain.user;

import com.faculdade.tcc.domain.dtos.requests.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity(name = "USER_TABLE")
@Table(name = "USER_TABLE")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String matricula;
    @Enumerated(EnumType.STRING)
    private UserType role;

    public User(UserRequestDTO data){
        this.name = data.name();
        this.email = data.email();
        this.matricula = data.matricula();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }



}
