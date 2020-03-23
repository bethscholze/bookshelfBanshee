package com.bookshelfBanshee.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("This is the login page");

        //username and password passed in post
        //set these in a new user object
        //pass this new user object into the userdao to insert it into the database
        //return a success to the screen if the username and password is found in the user table.
        //redirect to the users home page.
        /*
        GenericDao userDao = new GenericDao(User.class);
        userDao.insert();

        req.setAttribute("users", userDao.getAll());
         */
//        if (req.isUserInRole("admin")) {
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
//            dispatcher.forward(req, resp);
//        } else {
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
//            dispatcher.forward(req, resp);
//        }

    }

}
