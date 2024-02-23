package org.example.delete;

import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private static final String SELECT_ALL_COURSES = "SELECT * FROM courses;";
    private static final String INSERT_STUDENTS = "INSERT INTO students (name, YHP, description) VALUES (?, ?, ?);";

    public List<Course> selectAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COURSES);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                String name = rs.getString("name");
                int yhp = rs.getInt("YHP");
                String description = rs.getString("description");
                courses.add(new Course(courseId, name, yhp, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public void addCourses(String name, int yhp, String description){
        try(Connection connection = DBConnectionUtil.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(INSERT_STUDENTS);
            pstmt.setString(1,name);
            pstmt.setInt(2,yhp);
            pstmt.setString(3,description);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
