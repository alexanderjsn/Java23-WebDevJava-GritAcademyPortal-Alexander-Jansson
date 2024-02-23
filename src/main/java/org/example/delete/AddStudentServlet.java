package org.example.delete;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.delete.StudentDAO;

import java.io.IOException;


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    private final StudentDAO studentDAO =  new StudentDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchStudent.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // hämta in form data
        String Fname = request.getParameter("Fname");
        String Lname = request.getParameter("Lname");
        String hobby = request.getParameter("city");
        String city = request.getParameter("hobby");

        // lägger in data från form
        studentDAO.addStudents(Fname, Lname, city, hobby);

        // skickar ut igen
        response.sendRedirect("studentServlet");
    }
}
