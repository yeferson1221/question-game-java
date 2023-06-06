package com.game.question.service;

import com.game.question.domain.Answer;
import com.game.question.domain.Question;
import com.game.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getRandomQuestions(int count) {
        List<Question> allQuestions = questionRepository.findAll();
        int totalQuestions = allQuestions.size();

        if (count >= totalQuestions) {
            return allQuestions; // Return all questions if count is greater or equal to the total
        }

        // Shuffle the questions
        Collections.shuffle(allQuestions);

        // Return the first 'count' questions
        return allQuestions.subList(0, count);
    }

    public boolean checkAnswer(int questionId, int answerId) {
        Question question = questionRepository.findById(questionId).orElse(null);

        if (question == null) {
            return false; // Question not found
        }

        for (Answer answer : question.getAnswers()) {
            if (answer.getId() == answerId) {
                return answer.isCorrect();
            }
        }

        return false; // Answer not found
    }
}
