package com.faculdade.tcc.models.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "USER_TABLE")
@Table(name = "USER_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserModel {

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

}
