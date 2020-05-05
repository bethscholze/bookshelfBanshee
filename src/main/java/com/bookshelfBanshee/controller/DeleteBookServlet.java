package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.persistence.GenericDao;
import com.googlebooksapi.entity.VolumeInfo;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet(
        name = "DeleteBook",
        urlPatterns = {"/deleteBook"}
)

public class DeleteBookServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        int id = Integer.parseInt(req.getParameter("id"));
        List<VolumeInfo> googleBooksData = (ArrayList<VolumeInfo>)session.getAttribute("userGoogleBooks");
        VolumeInfo currentBookGoogle = googleBooksData.get(id);



        GenericDao<Book> bookDao= new GenericDao<>(Book.class);
        String isbnType = currentBookGoogle.getIndustryIdentifiers().get(0).getType();
        isbnType = isbnType.toLowerCase().replace("_","");
        logger.info(isbnType);
        String isbnNumber = currentBookGoogle.getIndustryIdentifiers().get(0).getIdentifier();
        logger.info(isbnNumber);
        List<Book> currentBookDbList = bookDao.getByPropertyEqual(isbnType, isbnNumber);
        Book currentBook = currentBookDbList.get(0);
        logger.info(currentBook);

       Set<UserBookData> userBookData = (Set<UserBookData>)session.getAttribute("userBookData");

       UserBookData toDelete = null;
       for(UserBookData book: userBookData) {
           if(book.getBook().equals(currentBook)) {
               toDelete = book;
               userBookData.remove(book);
               googleBooksData.remove(currentBookGoogle);
               break;
           }
       }

       GenericDao<UserBookData> userBookDataDao = new GenericDao<>(UserBookData.class);
       userBookDataDao.delete(toDelete);


//        session.setAttribute("userLists", userLists);

        session.setAttribute("currentBookGoogle", null);
        session.setAttribute("currentBookDb", null);
        session.setAttribute("currentBookData", null);
        session.setAttribute("userBookData", userBookData);
        session.setAttribute("userGoogleBooks", googleBooksData);

        //todo redirect instead of forward
        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);
    }
}




