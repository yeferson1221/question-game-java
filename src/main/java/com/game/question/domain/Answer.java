package com.game.question.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text", length = 255, nullable = false)
    private String text;

    @Column(name = "is_correct", nullable = false)
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonBackReference
    private Question question;

    /*
    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }


     */
}