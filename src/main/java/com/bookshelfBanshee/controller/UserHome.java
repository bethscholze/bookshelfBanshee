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
import java.io.IOException;

public class UserHome extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        GenericDao userDao = new GenericDao(User.class);
//        req.setAttribute("users", userDao.getAll());
//        GenericDao bookDao = new GenericDao(Book.class);
//        req.setAttribute("books", bookDao.getAll());
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
//        dispatcher.forward(req, resp);
    }
}
