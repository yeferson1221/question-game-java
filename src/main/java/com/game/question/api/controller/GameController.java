package com.game.question.api.controller;

import com.game.question.domain.Game;
import com.game.question.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
@CrossOrigin("http://localhost:4200/")
public class GameController {
    @Autowired
    private GameService gameService;

    //CREAR GAME
    @PostMapping("/create/{id}")
    public Game CreateGame(@RequestBody Game game, @PathVariable int id){
        return gameService.saveGame(game, id);
    }

    //LISTAR TODOS LOS JUEGOS
    @GetMapping
    public List<Game> getGames(){
        return gameService.getGame();
    }

    //ELIMINAR JUEGO
    @DeleteMapping("delete")
    public void deleteGame(@PathVariable int id){
        gameService.deleteGame(id);
    }

}
