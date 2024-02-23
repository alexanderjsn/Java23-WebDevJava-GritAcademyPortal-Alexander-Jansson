package org.example.delete;

import org.example.model.Student;
import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class associationDAO {

    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM association;";
    private static final String ADD_ASSOCIATION = "INSERT INTO association (student_id, course_id, teacher_id) VALUES ( ?, ?, ?);";


    public List<Student> getAssociation() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet rs = preparedStatement.executeQuery();
            {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int student_id = rs.getInt("student_id");
                    int course_id = rs.getInt("teacher_id");
                    int teacher_id = rs.getInt("course_id");

                    students.add(new Student(id, student_id, course_id, teacher_id));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
    public void addAssociation(int student_id, int course_id, int teacher_id){
        try(Connection connection = DBConnectionUtil.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(ADD_ASSOCIATION);
            pstmt.setInt(1,student_id);
            pstmt.setInt(2,course_id);
            pstmt.setInt(3,teacher_id);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
