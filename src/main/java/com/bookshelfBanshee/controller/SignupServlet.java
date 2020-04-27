package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(
        name = "Signup",
        urlPatterns = {"/signup"}
)
public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String retypedPassword = req.getParameter("password2");

        if (password.equals(retypedPassword)){
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            GenericDao<User> userDao = new GenericDao<>(User.class);
            userDao.insert(newUser);
            String successMessage = "Success account created! Please log in to get started.";
            session.setAttribute("signup", successMessage);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
            dispatcher.forward(req, resp);
        } else {
            String errorMessage = "Passwords do not match. Please retry.";
            session.setAttribute("signup", errorMessage);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/signup.jsp");
            dispatcher.forward(req, resp);
        }


    }
}
