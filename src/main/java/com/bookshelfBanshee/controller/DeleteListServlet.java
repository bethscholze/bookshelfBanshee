package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.UserList;
import com.bookshelfBanshee.persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(
        name = "DeleteList",
        urlPatterns = {"/deleteList"}
)
public class DeleteListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        List<UserList> userLists = (List<UserList>)session.getAttribute("userLists");
        UserList currentList = (UserList)session.getAttribute("currentList");

        GenericDao<UserList> bookListDao = new GenericDao<>(UserList.class);
        bookListDao.delete(currentList);


        session.setAttribute("keysOfBooksOnList", null);
        session.setAttribute("currentList", null);
        session.setAttribute("keysOfBooksNotOnList", null);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lists.jsp");
        dispatcher.forward(req, resp);
    }
}
