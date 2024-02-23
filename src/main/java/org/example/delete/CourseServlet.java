package org.example.delete;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.delete.CourseDAO;
import org.example.delete.Course;

import java.io.IOException;
import java.util.List;

@WebServlet("/courseServlet")
public class CourseServlet extends HttpServlet {
    private final CourseDAO courseDAO = new CourseDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Course> listCourse = courseDAO.selectAllCourses();
        request.setAttribute("listCourse", listCourse);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course-list.jsp");
        dispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // hämta in form data
        String name = request.getParameter("name");
        int yhp = Integer.parseInt(request.getParameter("yhp"));
        String description = request.getParameter("description");

        // Hämta DAO
        // lägger in data från form
        courseDAO.addCourses(name, yhp, description);

        // skickar ut igen
        response.sendRedirect("course-list.jsp");
    }

}