package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.MappedBook;
import com.bookshelfBanshee.entity.UserBookData;
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
        Map<Integer, MappedBook> mappedBooks = (Map<Integer, MappedBook>)session.getAttribute("userMappedBooks");

        int id = Integer.parseInt(req.getParameter("id"));

        Set<UserBookData> userBookData = mappedBooks.get(id).getUsersBookData();
        bookManager.deleteUserBookData(userBookData);
        mappedBooks.remove(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);
    }
}




