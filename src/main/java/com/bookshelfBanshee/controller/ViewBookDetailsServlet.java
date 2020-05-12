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

        //todo add a delete book data button for each userBookdata

        session.setAttribute("currentMappedBook", currentMappedBook);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookDetails.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        MappedBook currentMappedBook = (MappedBook) session.getAttribute("currentMappedBook");

        String dataLabel = req.getParameter("dataLabel");
        String dataValue = req.getParameter("dataValue");

        Book currentDBBook = bookManager.getBookDB(currentMappedBook.getBookId());
        User user = (User) session.getAttribute("user");
        Set<UserBookData> currentBookData = currentMappedBook.getUsersBookData();
        UserBookData newBookData = new UserBookData(user, currentDBBook, dataLabel, dataValue);
        GenericDao<UserBookData> userBookDataDao = new GenericDao<>(UserBookData.class);
        userBookDataDao.insert(newBookData);
        currentBookData.add(newBookData);
        currentMappedBook.setUsersBookData(currentBookData);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookDetails.jsp");
        dispatcher.forward(req, resp);
    }

}
