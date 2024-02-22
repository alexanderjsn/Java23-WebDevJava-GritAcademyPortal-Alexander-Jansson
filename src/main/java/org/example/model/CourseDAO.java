package org.example.model;

import org.example.model.Course;
import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private static final String SELECT_ALL_COURSES = "SELECT * FROM courses;";

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

}
