package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.BookList;
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
        List<BookList> userLists = (List<BookList>)session.getAttribute("userLists");
        BookList currentList = (BookList)session.getAttribute("currentList");

        GenericDao<BookList> bookListDao = new GenericDao<>(BookList.class);
        bookListDao.delete(currentList);

        session.setAttribute("currentList", userLists.get(0));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lists.jsp");
        dispatcher.forward(req, resp);
    }
}
