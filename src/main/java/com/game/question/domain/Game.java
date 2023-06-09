package com.game.question.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "game")
@Data
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 15, nullable = false )
    private String name;

    @Column(name = "points", nullable = false)
    private int points;

    @ManyToOne
    @JoinColumn(name = "user_id")
    //@JsonBackReference
    private User user;
}
