package com.game.question.service;

import com.game.question.domain.User;
import com.game.question.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User CreateUser(User user){
        return userRepository.save(user);
    }

    /*  public List<Question> getRandomQuestions(int count) {
        List<Question> allQuestions = (List<Question>) questionRepository.findAll();
        int totalQuestions = allQuestions.size();

        if (count >= totalQuestions) {
            return allQuestions; // Return all questions if count is greater or equal to the total
        }

        // Shuffle the questions
        Collections.shuffle(allQuestions);

        // Return the first 'count' questions
        return allQuestions.subList(0, count);
    }

     */

    public List<User> getUser(){
        List<User> allUser = (List<User>) userRepository.findAll();
        return allUser;
    }
}
