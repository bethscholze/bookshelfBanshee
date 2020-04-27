package com.bookshelfBanshee.controller;

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


        //username and password passed in post
        //set these in a new user object
        //pass this new user object into the userdao to insert it into the database
        //return a success to the screen if the username and password is found in the user table.
        //redirect to the users home page.

        HttpSession session = req.getSession();
        Set<BookList> userLists = (Set<BookList>)session.getAttribute("userLists");
        Set<UserBookData> userBookData = (Set<UserBookData>)session.getAttribute("userBooks");
        VolumeInfo currentBook = (VolumeInfo)req.getAttribute("currentBook");
        logger.info(currentBook);

        GenericDao userDao = new GenericDao(User.class);
        //User user = (User)userDao.getByPropertyEqual("username", username).get(0);
        //session.setAttribute("user", user);

        BookManager bookManager = new BookManager();
        Set<VolumeInfo> googleBooksData = new HashSet<>();
        try {
            googleBooksData = bookManager.getGoogleAPIBookData(userBookData);
        } catch (Exception e) {
            logger.error("Could not load Book data from api.");
        }


        session.setAttribute("userLists", userLists);
        session.setAttribute("userBooks", googleBooksData);
        //logger.info(user.toString());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookDetails.jsp");
        dispatcher.forward(req, resp);
    }


    //do post saves changed data for wards back to booksjsp?

}