package org.example.user.controller;

import org.example.user.entity.User;
import org.example.user.service.UserService;

import java.util.List;

public class UserController {
    private static final UserService userService = new UserService();

    public static void main(String[] args) {
        List<User> users = userService.getAllUsers();

        for (User user : users) {
            System.out.println(user);
        }

    }
}
