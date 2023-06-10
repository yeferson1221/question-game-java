package com.game.question.service;

import com.game.question.domain.Game;
import com.game.question.domain.User;
import com.game.question.repository.GameRepository;
import com.game.question.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    //CREAR UN JUEGO
    public Game saveGame(Game game, int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
       // List<Game> allgames = new ArrayList<>();
       // allgames.add(game);
        game.setUser(user);
      //  user.setGames(allgames);
        return gameRepository.save(game);
    }

    //LISTAR LOS JUEGOS
    public List<Game> getGame(){
        List<Game> allGames = (List<Game>) gameRepository.findAll();
        return allGames;
    }

    //LISTAR JUEGO DE  UN JUGADOR
    public List<Game> getAllgamesByUserId(int userId){
        List<Game> allGames = (List<Game>) gameRepository.findByUserId(userId);
        allGames.sort(Comparator.comparingInt(Game::getPoints).reversed());
        return allGames;
    }

    //LISTAR JUEGO MAYOR DE TODOS LOS JUGADORES
    public List<Game> getGameWithHighestScore(){
        List<Game> allGames = (List<Game>) gameRepository.findByOrderByPointsDesc();
        return allGames;
    }


    //AZTULIZAR LOS PUNTOS
    public void updateGamePoints(int gameId, boolean correctAnswer) {
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid game ID"));

        if (correctAnswer) {
            game.setPoints(game.getPoints() + 100);
        }

        // Guardar el objeto Game actualizado en la base de datos
        gameRepository.save(game);
    }

    public void deleteGame(int id){
        gameRepository.deleteById(id);
    }

}
