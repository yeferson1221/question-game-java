package com.game.question.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", length = 100, nullable = false)
    private String name;
    @Column(name = "email", length = 225, nullable = false, unique = true)
    private String email;
    @Column(name = "name", length = 100, nullable = false)
    private String password;
}
