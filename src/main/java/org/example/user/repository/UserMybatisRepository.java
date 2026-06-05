package org.example.user.repository;

import org.apache.ibatis.session.SqlSession;
import org.example.config.JDBCUtil;
import org.example.config.MybatisConfig;
import org.example.user.entity.User;
import org.example.user.mapper.UserMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserMybatisRepository {
    public List<User> findAll() {
       try (SqlSession session = MybatisConfig.getSqlSession()) {
           UserMapper mapper = session.getMapper(UserMapper.class);
           return mapper.findAll();
       }
    }

    public int save(User user) {
        try (SqlSession session = MybatisConfig.getSqlSession()) {
            System.out.println("DB 에 저장 되기 전 user 엔티티 : " + user);
            UserMapper mapper = session.getMapper(UserMapper.class);
            int affectedRow = mapper.save(user);
            session.commit();
            System.out.println("DB 에 저장 된 후 user 엔티티 : " + user);
            return affectedRow;
        }
    }

    // 수정
    public int update(User user) {
        try (SqlSession session = MybatisConfig.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            int result = mapper.update(user);
            session.commit();
            return result;
        }
    }

    // 삭제
    public int deleteById(int id) {
        try (SqlSession session = MybatisConfig.getSqlSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            int result = mapper.deleteById(id);
            session.commit();
            return result;
        }
    }
}
