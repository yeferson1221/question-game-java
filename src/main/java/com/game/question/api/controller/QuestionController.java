package com.game.question.api.controller;
import com.game.question.domain.Question;
import com.game.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
@CrossOrigin("http://localhost:4200/")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    //CREAR PREGUNTAS
    @PostMapping("/create")
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    //ACTUALIZAR PREGUNTAS
    @PutMapping("/update/{questionId}")
    public Question updateQuestion(@PathVariable int questionId, @RequestBody Question question) {
        question.setId(questionId);
        return questionService.updateQuestion(question);
    }

    //ELIMINAR PREGUNTAS
    @DeleteMapping("delete/{questionId}")
    public void deleteQuestion(@PathVariable int questionId) {
        questionService.deleteQuestion(questionId);
    }

    //LISTAR PREGUNTAS ALEATORIAS
    @GetMapping("/random/{count}")
    public List<Question> getRandomQuestions(@PathVariable int count) {
        return questionService.getRandomQuestions(count);
    }

    @GetMapping("/{questionId}/answer/{answerId}")
    public boolean checkAnswer(@PathVariable int questionId, @PathVariable int answerId) {
        return questionService.checkAnswer(questionId, answerId);
    }


}
