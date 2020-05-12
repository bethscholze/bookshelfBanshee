package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.MappedBook;
import com.bookshelfBanshee.entity.UserList;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.persistence.GenericDao;
import com.googlebooksapi.entity.VolumeInfo;

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
import java.util.Map;
import java.util.Set;

/**
 * The type Add to list.
 */
@WebServlet(
        name = "AddToList",
        urlPatterns = {"/addToList"}
)
public class AddToList extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        HttpSession session = req.getSession(false);
        UserList currentList = (UserList)session.getAttribute("currentList");
        Set<Integer> keysOfBooksOnList = (Set<Integer>)session.getAttribute("keysOfBooksOnList");
        Set<Integer> keysOfBooksNotOnList = (Set<Integer>)session.getAttribute("keysOfBooksNotOnList");
        int id = Integer.parseInt(req.getParameter("id"));
        //get from the db
        Book book = bookManager.getBookDB(id);
        Set<Book> currentBooks = currentList.getBooksOnList();
        currentBooks.add(book);
        currentList.setBooksOnList(currentBooks);
        GenericDao<UserList> bookListDao = new GenericDao<>(UserList.class);
        bookListDao.saveOrUpdate(currentList);

        keysOfBooksNotOnList.remove(id);
        keysOfBooksOnList.add(id);

        session.setAttribute("keysOfBooksOnList", keysOfBooksOnList);
        session.setAttribute("keysOfBooksNotOnList", keysOfBooksNotOnList);
        session.setAttribute("currentList", currentList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lists.jsp");
        dispatcher.forward(req, resp);
    }
}
