package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserHome extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //username and password passed in post
        //set these in a new user object
        //pass this new user object into the userdao to insert it into the database
        //return a success to the screen if the username and password is found in the user table.
        //redirect to the users home page.

//            if (req.isUserInRole("user")) {
        HttpSession session = req.getSession();
        String username = (String)req.getAttribute("username");
        logger.debug("here");
        logger.info(username);
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getByPropertyEqual("username", username);
        session.setAttribute("user", user);

        req.setAttribute("userBooks", user.getUserBooks());
        logger.info(user.toString());
//            }


//        GenericDao userDao = new GenericDao(User.class);
//        userDao.setUser();
//        req.setAttribute("user", userDao.getAll());
//        GenericDao bookDao = new GenericDao(Book.class);
//        req.setAttribute("books", bookDao.getAll());
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
//        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String)req.getAttribute("username");
        logger.debug("here");
        logger.info(username);
        GenericDao userDao = new GenericDao(User.class);
        User user = (User)userDao.getByPropertyEqual("username", username);
        session.setAttribute("user", user);

        req.setAttribute("userBooks", user.getUserBooks());
        logger.info(user.toString());

    }
}
