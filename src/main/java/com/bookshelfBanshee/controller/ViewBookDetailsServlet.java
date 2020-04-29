package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.BookList;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.persistence.GenericDao;
import com.googlebooksapi.VolumeInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        HttpSession session = req.getSession();
        int id = Integer.parseInt(req.getParameter("id"));
        //Set<BookList> userLists = (Set<BookList>)session.getAttribute("userLists");
        List<VolumeInfo> userBookData = (List<VolumeInfo>)session.getAttribute("userBooks");
        VolumeInfo currentBookGoogle = userBookData.get(id);

        GenericDao<Book> bookDao= new GenericDao<>(Book.class);
        String isbnType = currentBookGoogle.getIndustryIdentifiers().get(0).getType();
        String isbnNumber = currentBookGoogle.getIndustryIdentifiers().get(0).getIdentifier();
        List<Book> currentBookDb = bookDao.getByPropertyEqual(isbnType, isbnNumber);
//        session.setAttribute("userLists", userLists);
        session.setAttribute("currentBookGoogle", currentBookGoogle);
        session.setAttribute("currentBookDb", currentBookDb.get(0));
        logger.info(currentBookGoogle.toString());
        logger.info(currentBookDb.toString());
//
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookDetails.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int id = Integer.parseInt(req.getParameter("id"));
        Set<BookList> userLists = (Set<BookList>)session.getAttribute("userLists");
        List<VolumeInfo> userBookData = (List<VolumeInfo>)session.getAttribute("userBooks");
        VolumeInfo currentBook = userBookData.get(id);
        logger.info(currentBook);

//        session.setAttribute("userLists", userLists);
        session.setAttribute("currentBook", currentBook);
        logger.info(currentBook.toString());
//
        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookDetails.jsp");
        dispatcher.forward(req, resp);
    }

}
