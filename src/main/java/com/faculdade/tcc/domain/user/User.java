package com.faculdade.tcc.domain.user;

import com.faculdade.tcc.domain.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "USERS_TABLE")
@Table(name = "USER_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

}
