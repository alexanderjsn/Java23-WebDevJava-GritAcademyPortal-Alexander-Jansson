package org.example;
import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


    @WebServlet("/fetchData")
    public class FetchDataServlet extends HttpServlet {


        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            List<Suggestion> suggestions = new ArrayList<>();
            suggestions.add(new Suggestion("1"));
            suggestions.add(new Suggestion("2"));
            suggestions.add(new Suggestion("3"));

            Gson gson = new Gson();
            String json = gson.toJson(suggestions); // This will ensure "test" is properly quoted

            // Set the response type to JSON
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Write the JSON string to response
            response.getWriter().write(json);
        }}
