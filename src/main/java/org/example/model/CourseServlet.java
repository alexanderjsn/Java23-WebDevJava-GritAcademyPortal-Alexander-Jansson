package org.example.model;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.delete.Course;
import org.example.model.CourseDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminCourses")
public class CourseServlet extends HttpServlet {
    private final CourseDAO courseDAO = new CourseDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CourseBean> courses = courseDAO.allCourses();
        request.setAttribute("courses", courses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("allCourses.jsp");
        dispatcher.forward(request, response);
    }


}