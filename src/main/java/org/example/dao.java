package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class dao {
    // Uppdaterad SQL-fråga för att matcha de nya kolumnerna
    private static final String sql = "SELECT student_id, Fname, Lname, hobby, city FROM students WHERE Fname LIKE ? OR Lname LIKE ? LIMIT 5";

    public List<student> getSuggestions(String queryTerm) {
        List<student> students = new ArrayList<>();

        try (Connection connection = DBconnector.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + queryTerm + "%");
            pstmt.setString(2, "%" + queryTerm + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Skapa ett nytt Student-objekt för varje rad i resultatet
                student student = new student();
                student.setStudent_id(rs.getInt("student_id"));
                student.setfname(rs.getString("Fname"));
                student.setlname(rs.getString("Lname"));
                student.setHobby(rs.getString("hobby"));
                student.setCity(rs.getString("city"));
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}

        /*
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, "%" + queryTerm + "%");)}}
          */
