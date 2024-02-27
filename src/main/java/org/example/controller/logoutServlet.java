package org.example.controller;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.UserBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/logout")
public class logoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse rep) throws IOException {

        HttpSession session = req.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        session.setAttribute("user", user);
        session.invalidate();
        rep.sendRedirect("home.jsp");
    }
}