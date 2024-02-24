package org.example.model;

import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {
    private static final String SELECT_STUDENTS_COURSES = "SELECT c.id, c.name, c.description, c.yhp " +
            "FROM courses c " +
            "JOIN courseparticipants cp ON c.id = cp.course_id " +
            "JOIN users u ON u.id = cp.user_id " +
            "WHERE u.username = ?";


    String SELECT_OTHER_USERS = "SELECT cp.* FROM courseparticipants cp JOIN users u ON cp.user_id = u.id WHERE u.username = ?";

    private static final String SELECT_ALL = "SELECT * FROM courses";
    private static final String INSERT_STUDENT_INTO_COURSE = "INSERT INTO courseparticipants (user_id, course_id, role) VALUES (?, ?, ?);";

    String SELECT_ALL_OTHER_USERS = "SELECT * FROM courseparticipants cp ON u.id = cp.user_id WHERE  u.username = ?";



    public List<CourseparticipantsBeans> studentSamecourse(String username){
        List<CourseparticipantsBeans> studentSamecourse = new ArrayList<>();
        try(Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_OTHER_USERS);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){

                        CourseparticipantsBeans user = new CourseparticipantsBeans();
                        user.setId(rs.getInt("id"));
                        user.setUser_id(rs.getInt("user_id"));
                        user.setCourse_id(rs.getInt("course_id"));
                        user.setRole(rs.getString("role"));
                        studentSamecourse.add(user);


                    }
                } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return studentSamecourse;
    }

    public List
            <CourseBean> selectStudentCourses(String username) {
        List<CourseBean> studentCourses = new ArrayList<>();

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS_COURSES)) {

            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                CourseBean courseBean = new CourseBean();
                courseBean.setId(rs.getInt("id"));
                courseBean.setName(rs.getString("name"));
                courseBean.setYHP(rs.getInt("yhp"));
                courseBean.setDescription(rs.getString("description"));
                studentCourses.add(courseBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentCourses;
    }

    public List<CourseBean> allCourses() {
        List<CourseBean> allCourses = new ArrayList<>();

        try (Connection connection = DBConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {

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
