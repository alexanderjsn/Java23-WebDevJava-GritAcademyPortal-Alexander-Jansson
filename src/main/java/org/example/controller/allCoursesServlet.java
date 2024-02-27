package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.CourseBean;
import org.example.model.CourseDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/courses")
public class allCoursesServlet extends HttpServlet {
private static final CourseDAO courseDAO = new CourseDAO();

protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
    List<CourseBean> allCoursesList = courseDAO.getAllCourses();
    req.setAttribute("allCoursesList", allCoursesList);
    RequestDispatcher dispatcher = req.getRequestDispatcher("allUserCourses.jsp");
    dispatcher.forward(req,rep);
}


}

