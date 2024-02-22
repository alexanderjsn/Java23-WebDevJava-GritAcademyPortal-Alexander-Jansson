package org.example;

import org.example.model.Student;
import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {

    // SQL kommandon
    private static final String SEARCH_STUDENTS = "SELECT Fname FROM userTable WHERE username = ?;";
    private static final String INSERT_STUDENTS = "INSERT INTO students (Fname, Lname, city, hobby) VALUES (?, ?, ?, ?);";

    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students;";
    public List<Student> selectAllStudents(){
    List<Student> students = new ArrayList<>();
    try(Connection connection = DBConnectionUtil.getConnection()) {
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);
        ResultSet rs = preparedStatement.executeQuery();{
            while (rs.next()){
                int id = rs.getInt("student_id");
                String firstName = rs.getString("Fname");
                String lastName = rs.getString("Lname");
                String city = rs.getString("city");
                String hobby = rs.getString("hobby");
                students.add(new Student(id, firstName,lastName,city,hobby));
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
        return students;
    }

    public void addStudents(String Fname, String Lname, String city, String hobby){
        try(Connection connection = DBConnectionUtil.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(INSERT_STUDENTS);
            pstmt.setString(1,Fname);
            pstmt.setString(2,Lname);
            pstmt.setString(3,city);
            pstmt.setString(4,hobby);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Student> searchStudentsByName(String name) {
   List<Student> students = new ArrayList<>();
   try(Connection connection = DBConnectionUtil.getConnection()) {
    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE Fname LIKE ?");
       preparedStatement.setString(1,"%" + name + "%");
       ResultSet rs = preparedStatement.executeQuery();
    while (rs.next()){
        int id = rs.getInt("student_id");
        String firstName = rs.getString("Fname");
        String lastName = rs.getString("Lname");
        String city = rs.getString("city");
        String hobby = rs.getString("hobby");
        students.add(new Student(id,firstName,lastName,city,hobby));
    }

   } catch (SQLException e) {
       throw new RuntimeException(e);
   }
        return students;
    }
}
