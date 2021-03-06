package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.MappedBook;
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
import java.util.*;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        HttpSession session = req.getSession(false);
        ServletContext servletContext = getServletContext();
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");
        List<UserList> userLists = (List<UserList>)session.getAttribute("userLists");
        int id = 0;
        if(req.getParameter("id") != null){
            id = Integer.parseInt(req.getParameter("id"));
        }

        Map<Integer, MappedBook> mappedBooks = (Map<Integer, MappedBook>)session.getAttribute("userMappedBooks");
        UserList currentList = userLists.get(id);
        Set<Integer> keysOfBooksOnList = listManager.getBooksOnList(currentList);
        Set<Integer> keysOfBooksNotOnList = listManager.getBooksNotOnList(mappedBooks, keysOfBooksOnList);

        session.setAttribute("keysOfBooksOnList", keysOfBooksOnList);
        session.setAttribute("currentList", currentList);
        session.setAttribute("keysOfBooksNotOnList", keysOfBooksNotOnList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lists.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        dispatcher.forward(req, resp);
    }
}
