package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.StudentDAO;
import org.example.model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
   // hämtar instans av dao för student
    private final StudentDAO studentDAO = new StudentDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        // hämtar lista från studentDAO
        List<Student> listStudent = studentDAO.selectAllStudents();

        // skickar ut listra till student-list.jsp
        req.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(req,rep);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("searchName");
        StudentDAO studentDAO = new StudentDAO();
        List<Student> searchResults = studentDAO.searchStudentsByName(searchName);
        request.setAttribute("searchResults", searchResults);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchStudent.jsp");
        dispatcher.forward(request, response);
    }

}
