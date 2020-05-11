package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.*;
import com.bookshelfBanshee.persistence.GenericDao;
import com.googlebooksapi.entity.VolumeInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(
        name = "BookDetails",
        urlPatterns = {"/BookDetails"}
)

public class ViewBookDetailsServlet extends HttpServlet {

    //this will have a get that will load the selected book(the first book by default)
    // and a post
    //the post will be for editing adding and deleting


    //edit passes the book that it was clicked on to this servlet to return
    //this has to write the changed data to the database


    //doget catches book
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        HttpSession session = req.getSession(false);
        int id = Integer.parseInt(req.getParameter("id"));
        Map<Integer, MappedBook> mappedBooks = (Map<Integer, MappedBook>)session.getAttribute("userMappedBooks");
        MappedBook currentMappedBook = mappedBooks.get(id);
//        VolumeInfo currentBookGoogle = mappedBooks.get(id).getGoogleData();
//        Set<UserBookData> currentBookData = mappedBooks.get(id).getUsersBookData();

        session.setAttribute("currentMappedBook", currentMappedBook);
//
//        session.setAttribute("currentBookGoogle", currentBookGoogle);
////        session.setAttribute("currentBookDb", currentBook);
//        session.setAttribute("currentBookData", currentBookData);
//        logger.info(currentBookGoogle.toString());
////        logger.info(currentBook.toString());
//        logger.info(currentBookData.toString());
////
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookDetails.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String name = req.getParameter("dataLabel");
        String description = req.getParameter("dataValue");

        UserList newUserList = new UserList(name, description, user);

        GenericDao<UserList> bookListDao = new GenericDao<>(UserList.class);
        bookListDao.insert(newUserList);

        session.setAttribute("currentList", newUserList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lists.jsp");
        dispatcher.forward(req, resp);
    }

}
