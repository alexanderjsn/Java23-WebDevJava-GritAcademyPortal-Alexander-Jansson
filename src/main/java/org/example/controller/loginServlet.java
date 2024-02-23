package org.example.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.delete.userDAO;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private final static userDAO userdao = new userDAO();
    protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();


        // loggas ut efter 30min
        session.setMaxInactiveInterval(30*60);


        // CSRF skydd
        String csrfToken = UUID.randomUUID().toString();
        session.setAttribute("csrfToken",csrfToken);
        session.setAttribute("userStatus", "confirmed");


        boolean loginSuccess = userdao.checkLogin(username, password);


        session.setAttribute("user", username);
        if (loginSuccess){
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req,rep);
    }else {
            req.setAttribute("errorMessage", "Ogiltigt användarnamn eller lösenord");
            RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
            dispatcher.forward(req, rep);
        }
    }
}