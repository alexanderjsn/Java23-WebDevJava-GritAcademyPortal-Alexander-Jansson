package org.example.model;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.delete.Course;
import org.example.model.CourseDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminCourses")
public class CourseServlet extends HttpServlet {
    private final CourseDAO courseDAO = new CourseDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false); //false så det inte skapas ny
        UserBean user = (UserBean) session.getAttribute("user");

        // är användare inloggad + student annars redirect
        if(user == null || !"student".equals(user.getRole())){
            response.sendRedirect("home.jsp");
            return;
        }

        List<CourseBean> allCourses = courseDAO.allCourses();
        request.setAttribute("allCourses", allCourses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("allCourses.jsp");
        dispatcher.forward(request, response);
    }


}