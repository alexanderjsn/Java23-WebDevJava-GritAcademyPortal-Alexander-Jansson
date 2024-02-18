package org.example;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/fetchData")

public class Servlet extends HttpServlet{
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String testJson = "JSON TEXT";

    Gson gson = new Gson();
    String jsonData = gson.toJson(testJson);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    response.getWriter().write(jsonData);

}

}
