package org.example.delete;

import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class suggestionDAO {
    // Uppdaterad SQL-fråga för att matcha de nya kolumnerna
    private static final String sql = "SELECT student_id, Fname, Lname, hobby, city FROM students WHERE Fname LIKE ? OR Lname LIKE ? LIMIT 5";
    private static final String coursesql = "SELECT course_id, name FROM courses WHERE course_id LIKE ? OR name LIKE ? LIMIT 5";

    public List<student> getSuggestions(String queryTerm) {
        List<student> students = new ArrayList<>();

        try (Connection connection = DBConnectionUtil.getConnection();
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


    public List<Course> getSuggestionsCourse(String queryTerm) {
        List<Course> courses = new ArrayList<>();

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(coursesql)) {
            pstmt.setString(1, "%" + queryTerm + "%");
            pstmt.setString(2, "%" + queryTerm + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setName(rs.getString("name"));
                course.setYhp(rs.getInt("yhp"));
                course.getDescription(rs.getString("getDescription"));
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

}

        /*
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, "%" + queryTerm + "%");)}}
          */
