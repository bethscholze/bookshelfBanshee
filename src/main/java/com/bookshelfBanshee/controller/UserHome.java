package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.BookList;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(
        name = "UserHome",
        urlPatterns = {"/UserHome"}
)
public class UserHome extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){


        //username and password passed in post
        //set these in a new user object
        //pass this new user object into the userdao to insert it into the database
        //return a success to the screen if the username and password is found in the user table.
        //redirect to the users home page.

        HttpSession session = req.getSession();
        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");

        if(session.getAttribute("userGoogleBooks") == null) {
            logger.info("the users Books: {}", session.getAttribute("userGoogleBooks"));
            session.setAttribute("userGoogleBooks", null);

            String username = req.getRemoteUser();

            logger.info(username);
            User user = bookManager.getUser(username);
            Set<UserBookData> userBookData = user.getUserBooks();
            Set<Book> books = new HashSet<>();
            for (UserBookData bookData : userBookData) {
                books.add(bookData.getBook());
            }
            logger.debug("The books to call google api with: {}", books);
            List<VolumeInfo> googleBooksData = new ArrayList<>();
            try {
                googleBooksData = bookManager.getGoogleAPIBookData(books);
            } catch (Exception e) {
                logger.error("Could not load Book data from api.");
            }
            Set<BookList> userLists = user.getLists();
            session.setAttribute("user", user);
            session.setAttribute("userLists", userLists);
            session.setAttribute("userGoogleBooks", googleBooksData);
            session.setAttribute("userBookData", userBookData);
            logger.info(user.toString());
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException servletException) {
            logger.error(servletException);
        } catch (IOException ioException) {
            logger.error(ioException);
        }
    }

}
