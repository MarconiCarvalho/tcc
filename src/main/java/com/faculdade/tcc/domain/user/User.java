package com.faculdade.tcc.domain.user;

import com.faculdade.tcc.domain.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "USER_TABLE")
@Table(name = "USER_TABLE")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String matricula;
    @Enumerated(EnumType.STRING)
    private UserType role;

    public User(UserDTO data){
        this.name = data.name();
        this.email = data.email();
        this.matricula = data.matricula();
        this.role = data.role();
    }

    public User(){}

    public Long getId(){
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
