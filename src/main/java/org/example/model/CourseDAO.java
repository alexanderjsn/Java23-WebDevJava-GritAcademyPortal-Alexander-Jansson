package org.example.model;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    private static final String SELECT_COURSES = "SELECT c.* FROM courses c " +
            "JOIN courseparticipants cp ON c.id = cp.course_id " +
            "JOIN users u ON cp.user_id = u.id " +
            "WHERE u.username = ?";

    private static final String ALL_COURSES = "SELECT * FROM courses";

    public List<CourseBean> allStudentsandCourses(String username) {
        List<CourseBean> allCourses = new ArrayList<>();

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSES)) {
            preparedStatement.setString(1,username);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    CourseBean courseBean = new CourseBean();
                    courseBean.setId(rs.getInt("id"));
                    courseBean.setName(rs.getString("name"));
                    courseBean.setYHP(rs.getInt("yhp"));
                    courseBean.setDescription(rs.getString("description"));
                    allCourses.add(courseBean);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allCourses;
    }

    public List<CourseBean> allCourses(String username) {
        List<CourseBean> allCourses = new ArrayList<>();

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COURSES)) {
             preparedStatement.setString(1,username);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    CourseBean courseBean = new CourseBean();
                    courseBean.setId(rs.getInt("id"));
                    courseBean.setName(rs.getString("name"));
                    courseBean.setYHP(rs.getInt("yhp"));
                    courseBean.setDescription(rs.getString("description"));
                    allCourses.add(courseBean);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return allCourses;
    }

public List<CourseBean> getAllCourses() {
    List<CourseBean> allCourses = new ArrayList<>();

    try (Connection connection = DBConnectionUtil.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(ALL_COURSES)) {
        try (ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                CourseBean courseBean = new CourseBean();
                courseBean.setId(rs.getInt("id"));
                courseBean.setName(rs.getString("name"));
                courseBean.setYHP(rs.getInt("yhp"));
                courseBean.setDescription(rs.getString("description"));
                allCourses.add(courseBean);
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return allCourses;
}

}
