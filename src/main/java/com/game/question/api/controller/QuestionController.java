package com.game.question.api.controller;

import com.game.question.domain.Question;
import com.game.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/random/{count}")
    public List<Question> getRandomQuestions(@PathVariable int count) {
        return questionService.getRandomQuestions(count);
    }

    @PostMapping("/check-answer/{questionId}")
    public boolean checkAnswer(@PathVariable int questionId, @RequestParam int answerId) {
        return questionService.checkAnswer(questionId, answerId);
    }
}
