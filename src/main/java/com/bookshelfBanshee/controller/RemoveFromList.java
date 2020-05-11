package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserList;
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
import java.util.Set;

@WebServlet(
        name = "RemoveFromList",
        urlPatterns = {"/removeFromList"}
)
public class RemoveFromList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        HttpSession session = req.getSession(false);
        UserList currentList = (UserList)session.getAttribute("currentList");
//
//        List<VolumeInfo> booksNotOnList = (List<VolumeInfo>)session.getAttribute("booksNotOnList");
//
//        User user = (User) session.getAttribute("user");
//
//        int id = Integer.parseInt(req.getParameter("id"));
//        VolumeInfo bookToAdd = booksNotOnList.get(id);
//        //get from the db
//        Book book = bookManager.checkForExistingBook(bookToAdd);
//
//        Set<Book> currentBooks = currentList.getBooksOnList();
//        currentBooks.add(book);
//        currentList.setBooksOnList(currentBooks);
//        GenericDao<UserList> bookListDao = new GenericDao<>(UserList.class);
//        bookListDao.saveOrUpdate(currentList);
//
//        booksNotOnList.remove(id);
//
//        session.setAttribute("booksNotOnList", booksNotOnList);
//        session.setAttribute("currentList", currentList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/lists.jsp");
        dispatcher.forward(req, resp);
    }

}
