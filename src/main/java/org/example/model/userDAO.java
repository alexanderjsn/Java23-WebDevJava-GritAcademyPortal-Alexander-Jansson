package org.example.model;

import org.example.delete.DBconnector;
import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDAO {


    private String CHECK_LOGIN = "SELECT * FROM users WHERE username = ? AND password = ?";
    private String REGISTER_USER = "INSERT INTO users (username, fName, lName, phone, email, password, role) VALUES (?,?,?,?,?,?,?)";


    public UserBean checkLogin(String username, String password)  {
        UserBean user = new UserBean();
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            // om det finns en användare
            if (rs.next()) {
                // sätt nytt värde på setters under sessions gåmng
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setRole(rs.getString("role"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    public void registerUser(String username, String fName, String lName, String phone, String email, String password, String role)  {
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(REGISTER_USER)) {
            pstmt.setString(1, username);
            pstmt.setString(2, fName);
            pstmt.setString(3, lName);
            pstmt.setString(4, phone);
            pstmt.setString(5, email);
            pstmt.setString(6, password);
            pstmt.setString(7, role);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}