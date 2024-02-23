package org.example.delete;

import org.example.delete.DBconnector;
import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {


    private String CHECK_LOGIN = "SELECT * FROM users WHERE username = ? AND password = ?";
    private String REGISTER_USER = "INSERT INTO users (name, email, phone, password, username) VALUES (?,?,?,?,?)";


    public boolean checkLogin(String username, String password)  {
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void registerUser(String name, String email, String phone, String password, String username)  {

        try (Connection connection = DBconnector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(REGISTER_USER)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, phone);
            pstmt.setString(4, password);
            pstmt.setString(5, username);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}