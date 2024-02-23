package org.example.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.userDAO;
import org.example.model.UserBean;

import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private final static userDAO userdao = new userDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserBean user = userdao.checkLogin(username,password);


    }
}