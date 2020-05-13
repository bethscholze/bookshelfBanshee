package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.MappedBook;
import com.bookshelfBanshee.entity.UserList;
import com.bookshelfBanshee.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * The type Remove from list.
 */
@WebServlet(
        name = "RemoveFromList",
        urlPatterns = {"/removeFromList"}
)
public class RemoveFromList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");
        HttpSession session = req.getSession(false);
        UserList currentList = (UserList)session.getAttribute("currentList");
        Map<Integer, MappedBook> mappedBooks = (Map<Integer, MappedBook>)session.getAttribute("userMappedBooks");
        //below here
        Set<Integer> keysOfBooksOnList = (Set<Integer>)session.getAttribute("keysOfBooksOnList");
        int id = Integer.parseInt(req.getParameter("id"));

        Book book = bookManager.getBookDB(id);

        Set<Book> currentBooks = currentList.getBooksOnList();
        currentBooks.remove(book);
        currentList.setBooksOnList(currentBooks);
        GenericDao<UserList> bookListDao = new GenericDao<>(UserList.class);
        bookListDao.saveOrUpdate(currentList);
        keysOfBooksOnList.remove(id);
        Set<Integer> keysOfBooksNotOnList = listManager.getBooksNotOnList(mappedBooks, keysOfBooksOnList);

        session.setAttribute("keysOfBooksOnList", keysOfBooksOnList);
        session.setAttribute("keysOfBooksNotOnList", keysOfBooksNotOnList);
        session.setAttribute("currentList", currentList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lists.jsp");
        dispatcher.forward(req, resp);
    }

}
