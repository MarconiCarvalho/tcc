package com.faculdade.tcc.domain.TokenAuthentication;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "TOKEN_TABLE")
@Table(name = "TOKEN_TABLE")
@NoArgsConstructor
public class TokenAuthentication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime CreateAt;
}
