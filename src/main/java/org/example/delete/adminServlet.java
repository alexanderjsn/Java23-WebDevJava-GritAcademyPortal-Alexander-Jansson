package org.example.delete;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.delete.Course;
import org.example.delete.CourseDAO;
import org.example.delete.StudentDAO;
import org.example.model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class adminServlet extends HttpServlet {
    // hämtar instans av dao för student
    private CourseDAO courseDAO = new CourseDAO();

    private StudentDAO studentDAO = new StudentDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> listCourse = courseDAO.selectAllCourses();
        List<Student> listStudent = studentDAO.selectAllStudents();


        request.setAttribute("listStudent", listStudent);
        request.setAttribute("listCourse", listCourse);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }
}