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

@WebServlet("/StudentCoursesServlet")
public class StudentCoursesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); //false så det inte skapas ny
        UserBean user = (UserBean) session.getAttribute("user");

        // är användare inloggad + student annars redirect
        if(user == null || !"student".equals(user.getRole())){
            response.sendRedirect("login.jsp");
            return;
        }
        CourseDAO courseDAO = new CourseDAO();
        List<CourseBean> courses = courseDAO.selectStudentCourses(user.getUsername());
        request.setAttribute("courses", courses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("studentCourses.jsp");
        dispatcher.forward(request,response);
    }
}
