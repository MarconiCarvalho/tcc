package com.faculdade.tcc.domain.answers;

import com.faculdade.tcc.domain.question.Question;
import com.faculdade.tcc.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ANSWERS_TABLE")
@Table(name = "ANSWERS_TABLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OptionAnswers option;
    @ManyToOne
    @JoinColumn(name = "ID_QUESTION")
    private Question idQuestion;
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private User idUser;
}
