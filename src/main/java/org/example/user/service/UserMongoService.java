package org.example.user.service;

import org.example.user.dto.UserCreateRequest;
import org.example.user.dto.UserResponse;
import org.example.user.entity.User;
import org.example.user.repository.UserMongoPojoRepository;
import org.example.user.repository.UserMongoRepository;
import org.example.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMongoService {
    private final UserRepository userRepository = new UserRepository();
    private final UserMongoRepository userMongoRepository = new UserMongoRepository();
    private final UserMongoPojoRepository userMongoPojoRepository = new UserMongoPojoRepository();

    public List<UserResponse> getAllUsers() {
        userMongoPojoRepository.findAllPojo();
        List<User> users = userMongoRepository.findAll();
        List<UserResponse> result = new ArrayList<>();

        for (User user : users) {
            UserResponse dto = new UserResponse();
            dto.setId(user.getId());
            dto.setUserId(user.getUserId());
            dto.setName(user.getName());
            dto.setCreatedAt(user.getCreatedAt());
            result.add(dto);
        }

        return result;
    }

    public int addUser(UserCreateRequest request) {
        User user = new User();
        user.setUserId(request.getUserId());
        user.setName(request.getName());
        user.setPassword(request.getPassword());

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
