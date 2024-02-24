package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.CourseDAO;
import org.example.model.CourseparticipantsBeans;
import org.example.model.UserBean;

import java.io.IOException;
import java.util.List;

@WebServlet("/otherStudents")
public class otherStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession(false);
        UserBean user = (UserBean) session.getAttribute("user");

        if(user == null) {
            resp.sendRedirect("home.jsp");
            return;
        }

        CourseDAO courseDAO = new CourseDAO();
        List<CourseparticipantsBeans> sameStudents = courseDAO.studentSamecourse(user.getUsername());

        req.setAttribute("sameStudents", sameStudents);
        RequestDispatcher dispatcher = req.getRequestDispatcher("studentCourses.jsp");
        dispatcher.forward(req, resp);
    }



}
