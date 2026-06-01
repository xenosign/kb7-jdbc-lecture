package org.example.user.repository;

import org.example.config.JDBCUtil;
import org.example.user.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> findAll() {
        String sql = "SELECT * FROM `user`";
        List<User> users = new ArrayList<>();

        try (
                Connection conn = JDBCUtil.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUserId(rs.getString("user_id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public int save(User user) {
        String sql = "INSERT INTO `user` (user_id, name, password)"
                + " VALUES ('" + user.getUserId()
                + "', '" + user.getName()
                + "', '" + user.getPassword() + "')";

        try (Connection conn = JDBCUtil.getConnection();
            Statement stmt = conn.createStatement()) {
             int affectedRow = stmt.executeUpdate(sql);

             if (affectedRow > 0) {
                 System.out.println("사용자 추가 성공");
             } else {
                 System.out.println("사용자 추가 실패");
             }
            return affectedRow;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }













}
