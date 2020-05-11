package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.*;
import com.googlebooksapi.entity.IndustryIdentifiersItem;
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
        Map<Integer, MappedBook> mappedBooks = (Map<Integer, MappedBook>)session.getAttribute("userMappedBooks");
        if(mappedBooks == null){
            String username = req.getRemoteUser();

            logger.info(username);
            User user = bookManager.getUser(username);
            Set<UserBookData> userBookData = user.getUserBooks();
            Set<Book> books = new HashSet<>();
            for (UserBookData bookData : userBookData) {
                books.add(bookData.getBook());
            }

            logger.debug("The books to call google api with: {}", books);
            List<UserList> userLists = user.getLists();

            mappedBooks = bookManager.getGoogleAPIBookData(books, userBookData);

            UserList currentList = userLists.get(0);
            session.setAttribute("currentList", currentList);
            logger.info("all books mapped: {}", mappedBooks );


            session.setAttribute("user", user);
            session.setAttribute("userLists", userLists);
            session.setAttribute("userMappedBooks", mappedBooks);
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
