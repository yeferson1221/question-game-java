package com.game.question.repository;

import com.game.question.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    @Query("SELECT g FROM Game g WHERE g.user.id = :userId  ORDER BY g.points DESC")
    List<Game> findByUserId(@Param("userId") int userId);

    @Query("SELECT g FROM Game g ORDER BY g.points DESC")
    List<Game> findByOrderByPointsDesc();

}
