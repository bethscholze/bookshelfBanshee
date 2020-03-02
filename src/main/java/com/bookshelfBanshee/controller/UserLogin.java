package com.bookshelfBanshee.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/login"}
)

public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //username and password passed in post
        //set these in a new user object
        //pass this new user object into the userdao to insert it into the database
        //return a success to the screen if the username and password is found in the user table.
        /*
        GenericDao userDao = new GenericDao(User.class);
        userDao.insert();
        req.setAttribute("users", userDao.getAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);

        */
    }
}
