package com.game.question.api.controller;
import com.game.question.domain.Question;
import com.game.question.service.GameService;
import com.game.question.service.QuestionService;
import com.game.question.utils.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin("http://localhost:4200/")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private GameService gameService;

    @Autowired
    private AuthInterceptor authInterceptor;

    //CREAR PREGUNTAS
    @PostMapping("/create")
    public Question createQuestion( @RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    //ACTUALIZAR PREGUNTAS
    @PutMapping("/update/{questionId}")
    public Question updateQuestion(@PathVariable int questionId, @RequestBody Question question) {
        question.setId(questionId);
        return questionService.updateQuestion(question);
    }

    //LISTAR PREGUNTAS ALEATORIAS
    @GetMapping("/random/{count}")
    public List<Question> getRandomQuestions(@PathVariable int count) {
        return questionService.getRandomQuestions(count);
    }

    //OPTENER RESPUIESTA DE LA PREGUNTA
    @GetMapping("/check-answer/{questionId}/{answerId}/{gameId}")
    public boolean checkAnswer(@PathVariable int questionId, @PathVariable int answerId,
                               @PathVariable int gameId) {
        boolean correctAnswer = questionService.checkAnswer(questionId, answerId);

        gameService.updateGamePoints(gameId, correctAnswer);

        return correctAnswer;
    }

    //ELIMINAR PREGUNTAS
    @DeleteMapping("delete/{questionId}")
    public void deleteQuestion(@PathVariable int questionId) {
        questionService.deleteQuestion(questionId);
    }


}
