package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.UserBookData;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The type Delete book servlet.
 */
@WebServlet(
        name = "DeleteBook",
        urlPatterns = {"/deleteBook"}
)

public class DeleteBookServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");

        int id = Integer.parseInt(req.getParameter("id"));
        List<VolumeInfo> googleBooksData = (ArrayList<VolumeInfo>)session.getAttribute("userGoogleBooks");
        VolumeInfo currentBookGoogle = googleBooksData.get(id);

        Book currentBook = bookManager.checkForExistingBook(currentBookGoogle);
        logger.info(currentBook);

        Set<UserBookData> userBookData = (Set<UserBookData>)session.getAttribute("userBookData");
        userBookData = bookManager.deleteUserBookData(userBookData, currentBook);

        googleBooksData.remove(currentBookGoogle);
//        session.setAttribute("userLists", userLists);

        session.setAttribute("currentBookGoogle", null);
        session.setAttribute("currentBookDb", null);
        session.setAttribute("currentBookData", null);
        session.setAttribute("userBookData", userBookData);
        session.setAttribute("userGoogleBooks", googleBooksData);

        //todo redirect instead of forward
        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);
    }
}




