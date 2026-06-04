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

    public int deleteById(int id) {
        String sql = "DELETE FROM `user` WHERE id = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public int update(User user) {
        String sql = "UPDATE `user` SET user_id = ?, name = ?, password = ? WHERE id = ?";

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
