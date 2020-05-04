package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.persistence.GenericDao;
import com.googlebooksapi.entity.VolumeInfo;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(
        name = "AddBook",
        urlPatterns = {"/addBook"}
)

public class AddBookServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        //todo figure out why this isn't working, for some reason the client can't make a second request if I use the same book manager
//        BookManager bookManager = (BookManager) session.getAttribute("bookManager");

        BookManager bookManager = new BookManager();

        String searchTerm = req.getParameter("searchTerm");
        searchTerm = searchTerm.replaceAll("\\s", "+");
        String searchType = req.getParameter("searchType");
        logger.info(searchTerm);
        logger.info(searchType);

        List<VolumeInfo> bookResults = new ArrayList<>();
        try {
            bookResults = bookManager.searchGoogleAPIBook(searchType, searchTerm);
        } catch (Exception e) {
            logger.error("Could not load Book data from api.");
        }

//        session.setAttribute("userLists", userLists);

        session.setAttribute("bookResults", bookResults);
        logger.info(bookResults);
//
        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        HttpSession session = req.getSession();
//        Book currentDBBook = (Book) session.getAttribute("currentBookDb");
//        User user = (User) session.getAttribute("user");
//        Set<UserBookData> currentBookData = (Set<UserBookData>)session.getAttribute("currentBookData");
//        String dataLabel = req.getParameter("dataLabel");
//        String dataValue = req.getParameter("dataValue");
//
//        UserBookData newBookData = new UserBookData(user, currentDBBook, dataLabel, dataValue);
//
//        GenericDao<UserBookData> userBookDataDao = new GenericDao<>(UserBookData.class);
//
//        userBookDataDao.insert(newBookData);
//
//        Set<UserBookData> userBookData = (Set<UserBookData>)session.getAttribute("userBookData");
//
//        currentBookData.add(newBookData);
//        userBookData.add(newBookData);
//        session.setAttribute("userBookData", userBookData);
//        session.setAttribute("currentBookData", currentBookData);
//
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookDetails.jsp");
//        dispatcher.forward(req, resp);
//    }
}
