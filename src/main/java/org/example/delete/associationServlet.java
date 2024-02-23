package org.example.delete;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.delete.associationDAO;
import org.example.model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/association")
public class associationServlet extends HttpServlet {
    // hämtar instans av dao för student
    private final associationDAO associationDAO = new associationDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        // hämtar lista från studentDAO
        List<Student> listAll = associationDAO.getAssociation();

        // skickar ut listra till student-list.jsp
        req.setAttribute("listAll", listAll);
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
        dispatcher.forward(req,rep);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int student_id = Integer.parseInt(request.getParameter("student_id"));
        int course_idd = Integer.parseInt(request.getParameter("course_id"));
        int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));

        // lägger in data från form
        associationDAO.addAssociation(student_id, course_idd, teacher_id);

        // skickar ut igen
        response.sendRedirect("admin");
    }

}