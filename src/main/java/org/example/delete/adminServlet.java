package org.example.delete;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.CourseBean;
import org.example.model.CourseDAO;
import org.example.model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin")
public class adminServlet extends HttpServlet {
    // hämtar instans av dao för student
    private CourseDAO courseDAO = new CourseDAO();

    private StudentDAO studentDAO = new StudentDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> listStudent = studentDAO.selectAllStudents();


        request.setAttribute("listStudent", listStudent);

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.forward(request, response);
    }
}