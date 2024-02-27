package org.example.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.CourseBean;
import org.example.model.CourseDAO;
import org.example.model.UserBean;

import java.io.IOException;
import java.util.List;

@WebServlet("/allCourses")
public class CourseServlet extends HttpServlet {
    private final UserBean usercourses = new UserBean();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false); //false så det inte skapas ny
        UserBean user = (UserBean) session.getAttribute("user");
        CourseDAO courseDAO = new CourseDAO();
        String username = ((UserBean) request.getSession().getAttribute("user")).getUsername();


        // är användare inloggad + student annars redirect
        if(user == null ){
            response.sendRedirect("home.jsp");
            return;
        }

        List<CourseBean> allCourses = courseDAO.allCourses(username);
        request.setAttribute("allCourses", allCourses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("allCourses.jsp");
        dispatcher.forward(request, response);
    }


}