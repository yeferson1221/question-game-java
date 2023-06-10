package com.game.question.service;

import com.game.question.domain.User;
import com.game.question.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //CREAR USUARIO
    public User CreateUser(User user){
        return userRepository.save(user);
    }

    //OPTENER LOS USUARIOS
    public List<User> getUser(){
        List<User> allUser = (List<User>) userRepository.findAll();
        return allUser;
    }

    //ACTUALIZAR
    public User updateUserById(int id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + id));

        existingUser.setName(user.getName());
        // Update other properties as needed

        return userRepository.save(existingUser);
    }

    //ELIMINAR
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    //LOGIARSE CREDENCIALES

    public User idCredential(String email, String password) {
        List<User> userList = userRepository.findByEmailAndPassword(email, password);

        if (!userList.isEmpty()) {
            return userList.get(0);
        }

        return null;
    }

}
