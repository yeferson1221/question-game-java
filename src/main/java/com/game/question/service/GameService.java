package com.game.question.service;

import com.game.question.domain.Game;
import com.game.question.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public Game saveGame(Game game){
        return gameRepository.save(game);
    }
    /*
      public List<User> getUser(){
        List<User> allUser = (List<User>) userRepository.findAll();
        return allUser;
    }
     */
    public List<Game> getGame(){
        List<Game> allGames = (List<Game>) gameRepository.findAll();
        return allGames;
    }
}
