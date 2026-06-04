package org.example.user.mapper;

import org.example.user.dto.UserCreateRequest;
import org.example.user.dto.UserResponse;
import org.example.user.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    int save(User user);
    int update(User user);
    int deleteById(int id);







}
