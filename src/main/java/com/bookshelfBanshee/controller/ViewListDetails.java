package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.BookList;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.persistence.GenericDao;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");
        int id = Integer.parseInt(req.getParameter("id"));
        List<BookList> userLists = (List<BookList>)session.getAttribute("userLists");
        List<VolumeInfo> googleBooksData = (ArrayList<VolumeInfo>)session.getAttribute("userGoogleBooks");
        BookList currentList = userLists.get(id);
        List<VolumeInfo> booksNotOnList = googleBooksData;
        Set<Book> booksOnList = currentList.getBookList();
        //todo add this method to bookManager?
        for(VolumeInfo googleBook:googleBooksData){
            List<IndustryIdentifiersItem> isbns = googleBook.getIndustryIdentifiers();
            for(Book book: booksOnList){
                if(isbns.get(0).getIdentifier().equals(book.getIsbn10()) ||
                        isbns.get(0).getIdentifier().equals(book.getIsbn13())){
                    booksNotOnList.remove(googleBook);
                }
            }
        }
        List<VolumeInfo> googleBooksOnList = bookManager.//get volumeInfo whare book == volume info book
        //create a list of userbooks that arent on the list and show them with add buttons
        session.setAttribute("currentList", currentList);
        session.setAttribute("booksNotOnList", booksNotOnList);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession(false);
        ServletContext servletContext = getServletContext();
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");
        User user = (User) session.getAttribute("user");
        List<BookList> userLists = (List<BookList>)session.getAttribute("userLists");
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        BookList newList = new BookList(name, description, user);

        GenericDao<BookList> bookListDao = new GenericDao<>(BookList.class);
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
