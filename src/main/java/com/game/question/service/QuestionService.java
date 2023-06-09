package com.game.question.service;

import com.game.question.domain.Answer;
import com.game.question.domain.Question;
import com.game.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }


    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public void deleteQuestion(int questionId) {
        questionRepository.deleteById(questionId);
    }


//_----------------------------------------------------------------

    //OPTNER  NUMERO DE PREGUNTAS ALEATORIAS
    public List<Question> getRandomQuestions(int count){
        List<Question> allQuestions = (List<Question>) questionRepository.findAll();
        int totalQuestions = allQuestions.size();


        if (count > totalQuestions) {
            return allQuestions; // Devuelve todas las preguntas si el recuento es mayor al total
        }

        // Mezcla las preguntas
        Collections.shuffle(allQuestions);

        // Devuelve las primeras 'count' preguntas
        return allQuestions.subList(0, count);
    }

    //OPTENER PREGUNTA CORRECTA Y  SI Es CORRECTA SUMA 100 AL JUEGO
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
