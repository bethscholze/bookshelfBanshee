package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.MappedBook;
import com.bookshelfBanshee.entity.User;
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
import java.util.*;

/**
 * The type Add book servlet.
 */
@WebServlet(
        name = "AddBook",
        urlPatterns = {"/addBook"}
)

public class AddBookServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");

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

        session.setAttribute("bookResults", bookResults);
        logger.info(bookResults);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        List<VolumeInfo> bookResults = (List<VolumeInfo>)session.getAttribute("bookResults");
        User user = (User) session.getAttribute("user");

        int id = Integer.parseInt(req.getParameter("bookToAdd"));
        //get the google book data for this book
        VolumeInfo bookToAdd = bookResults.get(id);

        //check if the book is in the db already, return a new book or the book from the db
        Map<Integer, MappedBook> mappedBooks = (Map<Integer, MappedBook>)session.getAttribute("userMappedBooks");
        Book book = bookManager.checkForExistingBook(bookToAdd);

        if(!mappedBooks.containsKey(book.getId())){
            UserBookData newUserBookData = new UserBookData(user, book);
            GenericDao<UserBookData> userBookDao = new GenericDao<>(UserBookData.class);
            userBookDao.insert(newUserBookData);
            Set<UserBookData> data = new HashSet<>();
            data.add(newUserBookData);
            MappedBook newBook = new MappedBook(book.getId(), data, bookToAdd);
            mappedBooks.put(book.getId(), newBook);
        }
        session.setAttribute("userMappedBooks", mappedBooks);
        session.setAttribute("bookResults", null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);
    }
}
