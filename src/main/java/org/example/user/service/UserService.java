package org.example.user.service;

import org.example.user.entity.User;
import org.example.user.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public int addUser(User user) {
        return userRepository.save(user);
    }
}
