package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.CourseParticipant;
import org.example.model.UserBean;
import org.example.model.studentsCoursesDAO;


import java.io.IOException;
import java.util.List;

@WebServlet("/listStudents")
public class allStudentsServlet extends HttpServlet {
    private static final studentsCoursesDAO studentDAO = new studentsCoursesDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<UserBean> allStudents = studentDAO.getAllUsers();
        request.setAttribute("allStudents", allStudents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("allStudents.jsp");
        dispatcher.forward(request, response);
    }
}
