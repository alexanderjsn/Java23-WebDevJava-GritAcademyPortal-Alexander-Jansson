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

@WebServlet("/all")

public class Allstudentcourses extends HttpServlet {
    private org.example.model.studentsCoursesDAO studentsCoursesDAO = new studentsCoursesDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); //false så det inte skapas ny
        String username = ((UserBean) request.getSession().getAttribute("user")).getUsername();
        List<CourseParticipant> allStudentCourses = studentsCoursesDAO.allCourses(username);
        request.setAttribute("allStudentCourses", allStudentCourses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("all.jsp");
        dispatcher.forward(request, response);
    }
}
