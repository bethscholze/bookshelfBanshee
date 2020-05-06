package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.BookList;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.persistence.GenericDao;
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
import java.util.List;
import java.util.Set;

@WebServlet(
        name = "viewList",
        urlPatterns = {"/viewList"}
)

public class ViewListDetails extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //this will have a get that will load the selected list(the first list by default)
        // and a post
        //the post will be for editing adding and deleting lists
        // this page will have to have the bookManager passes as well so you can add books
        HttpSession session = req.getSession(false);
        ServletContext servletContext = getServletContext();
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");
        int id = Integer.parseInt(req.getParameter("id"));
        List<BookList> userLists = (List<BookList>)session.getAttribute("userLists");
        BookList currentList = userLists.get(id);
        session.setAttribute("currentList", currentList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lists.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException servletException) {
            logger.error(servletException);
        } catch (IOException ioException) {
            logger.error(ioException);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Book currentDBBook = (Book) session.getAttribute("currentBookDb");
        User user = (User) session.getAttribute("user");
        Set<UserBookData> currentBookData = (Set<UserBookData>)session.getAttribute("currentBookData");
        String dataLabel = req.getParameter("dataLabel");
        String dataValue = req.getParameter("dataValue");

        UserBookData newBookData = new UserBookData(user, currentDBBook, dataLabel, dataValue);

        GenericDao<UserBookData> userBookDataDao = new GenericDao<>(UserBookData.class);

        userBookDataDao.insert(newBookData);

        Set<UserBookData> userBookData = (Set<UserBookData>)session.getAttribute("userBookData");

        currentBookData.add(newBookData);
        userBookData.add(newBookData);
        session.setAttribute("userBookData", userBookData);
        session.setAttribute("currentBookData", currentBookData);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/bookDetails.jsp");
        dispatcher.forward(req, resp);
    }
}
