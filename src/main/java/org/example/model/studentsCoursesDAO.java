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

public class studentsCoursesDAO {

    private static final String SELECT_CLASS = "SELECT cp.* FROM courseparticipants cp " +
            "JOIN users u ON cp.user_id = u.id " +
            "WHERE cp.course_id IN ( " +
            "SELECT course_id FROM courseparticipants WHERE user_id = ( " +
            "SELECT id FROM users WHERE username = ? ))";

    private static final String SELECT_ALL = "SELECT * FROM courseparticipants";

    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM users WHERE role = 'student'";


    public List<UserBean> getAllUsers(){
        List<UserBean> users = new ArrayList<>();
        try(Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                UserBean user = new UserBean();
                user.setfName(rs.getString("fName"));
                user.setlName(rs.getString("lName"));
                user.setEmail(rs.getString("town"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setRole(rs.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public List<CourseParticipant> selectSameStudentCourses(String username){
        List<CourseParticipant> allStudentCourses = new ArrayList<>();
        try(Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASS);
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();{
                while (rs.next()){
                    int id = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    int courseId = rs.getInt("course_id");
                    String role = rs.getString("role");
                    allStudentCourses.add(new CourseParticipant(id, userId,courseId,role));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allStudentCourses;
    }


    public List<CourseParticipant> allCourses(String username){
        List<CourseParticipant> allStudentCourses = new ArrayList<>();
        try(Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();{
                while (rs.next()){
                    int id = rs.getInt("id");
                    int userId = rs.getInt("user_id");
                    int courseId = rs.getInt("course_id");
                    String role = rs.getString("role");
                    allStudentCourses.add(new CourseParticipant(id, userId,courseId,role));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allStudentCourses;
    }


}
