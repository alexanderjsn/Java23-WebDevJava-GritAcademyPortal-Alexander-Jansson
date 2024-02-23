package org.example.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.delete.userDAO;

import java.io.IOException;


@WebServlet("/register")
public class registerServlet extends HttpServlet {

    private static final userDAO userdao = new userDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        userdao.registerUser(username,name,phone,email,password);

        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req,rep);

    }
}