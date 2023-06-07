package com.game.question.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tex", length = 255, nullable = false)
    private String tex;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    //@JsonBackReference
    private List<Answer> answers = new ArrayList<>();



    /*
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }


     */
}

