package org.example.controller;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.userDAO;
import org.example.model.UserBean;

import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private final static userDAO userdao = new userDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // hämtar nu våra hämtade user värden från metoden (setters)
        UserBean user = userdao.checkLogin(username,password);

        if(user != null){

            HttpSession session = req.getSession();
            // sätter värdena på sessionen så uppgifterna sparas genom
            //sessionen
            session.setAttribute("user", user);
            // hämtar användarens roll
            String userRole = user.getRole();

            // skickar till olika sidor baserat på roll
            switch(userRole){
                case "teacher":
                    rep.sendRedirect("teacherHome.jsp");
                    break;
                case "student":
                    rep.sendRedirect("studentHome.jsp");
                    break;
                    // default sida att se kurser om man inte är
                    // registrerad
                default:
                    rep.sendRedirect("anonymousHome.jsp");
                    break;
            }

        }else{
            req.setAttribute("error", "Wrong username or password");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req,rep);
        }

        }


    }
