package org.example.user.service;

import org.example.user.entity.User;
import org.example.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public int addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> searchByName(String name) {
        List<User> allUsers = userRepository.findAll();
        List<User> result = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getName().contains(name)) {
                result.add(user);
            }
        }
        return result;
    }

    public List<User> searchByName2(String name) {
        return userRepository.findAll().stream()
                .filter(user -> user.getName().contains(name))
                .collect(Collectors.toList());
    }

    public int deleteUserById(int id) {
        int affectedRow = userRepository.deleteById(id);

        if (affectedRow > 0) {
            System.out.println("회원 삭제 성공!");
        } else {
            System.out.println("회원 삭제 실패");
        }

        return affectedRow;
    }

    public int updateUser(User user) {
        return userRepository.update(user);
    }






}
