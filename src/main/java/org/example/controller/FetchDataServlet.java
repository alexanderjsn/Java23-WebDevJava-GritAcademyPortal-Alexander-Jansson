package org.example.controller;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.suggestionDAO;
import org.example.delete.student;

import java.io.IOException;
import java.util.List;


    @WebServlet("/fetchData")
    public class FetchDataServlet extends HttpServlet {

    private final suggestionDAO Dao = new suggestionDAO();
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String queryTerm = request.getParameter("queryTerm");
            List<student> suggestions = Dao.getSuggestions(queryTerm);

            Gson gson = new Gson();
            String json = gson.toJson(suggestions);

            // Set the response type to JSON
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            // Write the JSON string to response
            response.getWriter().write(json);
        }}
