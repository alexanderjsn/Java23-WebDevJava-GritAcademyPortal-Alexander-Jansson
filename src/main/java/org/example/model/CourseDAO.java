package org.example.model;

import org.example.delete.Course;
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

    String SELECT_ALL_OTHER_USERS = "* FROM courseparticipants cp ON u.id = cp.user_id WHERE  u.username != ?";



    public List<UserBean> studentSamecourse(String username){
        List<UserBean> studentSamecourse = new ArrayList<>();
        try(Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_OTHER_USERS);
            pstmt.setString(1,username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                int courseID = rs.getInt("course_id");
                try(PreparedStatement pstmtOtherUsers = connection.prepareStatement(SELECT_ALL_OTHER_USERS)){
                    pstmtOtherUsers.setString(1, username);
                    ResultSet rsOtherUsers = pstmtOtherUsers.executeQuery();

                    while(rsOtherUsers.next()){
                        UserBean user = new UserBean();
                        user.setId(rsOtherUsers.getInt("id"));
                        user.setUsername(rsOtherUsers.getString("username"));
                        user.setRole(rsOtherUsers.getString("role"));
                        studentSamecourse.add(user);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
            e.printStackTrace(); // Eller hantera exception på ett lämpligt sätt
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
