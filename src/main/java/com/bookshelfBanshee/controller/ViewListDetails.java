package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.UserList;
import com.bookshelfBanshee.entity.User;
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

/**
 * The type View list details.
 */
@WebServlet(
        name = "viewList",
        urlPatterns = {"/viewList"}
)

public class ViewListDetails extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        //this will have a get that will load the selected list(the first list by default)
        // and a post
        //the post will be for editing adding and deleting lists
        // this page will have to have the bookManager passes as well so you can add books
        HttpSession session = req.getSession(false);
        ServletContext servletContext = getServletContext();
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");
        int id = Integer.parseInt(req.getParameter("id"));
        List<UserList> userLists = (List<UserList>)session.getAttribute("userLists");
        UserList currentList = userLists.get(id);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){
        //this will have a get that will load the selected list(the first list by default)
        // and a post
        //the post will be for editing
        // this page will have to have the bookManager passes as well so you can add books
        HttpSession session = req.getSession(false);
        ServletContext servletContext = getServletContext();
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");
        User user = (User) session.getAttribute("user");
        List<UserList> userLists = (List<UserList>)session.getAttribute("userLists");
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        UserList newList = new UserList(name, description, user);

        GenericDao<UserList> bookListDao = new GenericDao<>(UserList.class);
        userLists.add(newList);

        bookListDao.insert(newList);

        session.setAttribute("currentList", newList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lists.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException servletException) {
            logger.error(servletException);
        } catch (IOException ioException) {
            logger.error(ioException);
        }


    }
}
