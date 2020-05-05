package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
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
        name = "AddBook",
        urlPatterns = {"/addBook"}
)

public class AddBookServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        ServletContext servletContext = getServletContext();
        BookManager bookManager = (BookManager)servletContext.getAttribute("bookManager");
        ListManager listManager = (ListManager)servletContext.getAttribute("listManager");

        String searchTerm = req.getParameter("searchTerm");
        searchTerm = searchTerm.replaceAll("\\s", "+");
        String searchType = req.getParameter("searchType");
        logger.info(searchTerm);
        logger.info(searchType);

        List<VolumeInfo> bookResults = new ArrayList<>();
        try {
            bookResults = bookManager.searchGoogleAPIBook(searchType, searchTerm);
        } catch (Exception e) {
            logger.error("Could not load Book data from api.");
        }

//        session.setAttribute("userLists", userLists);

        session.setAttribute("bookResults", bookResults);
        logger.info(bookResults);
//
        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        List<VolumeInfo> googleBooksData = (List<VolumeInfo>)session.getAttribute("userGoogleBooks");
        List<VolumeInfo> bookResults = (List<VolumeInfo>)session.getAttribute("bookResults");
        int id = Integer.parseInt(req.getParameter("bookToAdd"));
        VolumeInfo bookToAdd = bookResults.get(id);

        //todo chekc if this is working, i think I need .eqauls and hashcode in volumeInfo
        Set<VolumeInfo> setGoogleBooks = new HashSet<>(googleBooksData);
        if (setGoogleBooks.add(bookToAdd)) {
            logger.info("Book added to google results: {}", bookToAdd);
            googleBooksData.add(bookToAdd);
        }

        List<IndustryIdentifiersItem> isbns = bookToAdd.getIndustryIdentifiers();
        GenericDao<Book> bookDao = new GenericDao<>(Book.class);
        Book newBook = new Book();
        final int ISBN10_SIZE = 10;
        final int ISBN13_SIZE = 13;
        String isbnType;
        String isbnNumber;
        Boolean insertBook = true;

        for(IndustryIdentifiersItem isbn: isbns){
            isbnType = isbn.getType();
            isbnType = isbnType.toLowerCase().replace("_","");

            isbnNumber = isbn.getIdentifier();
            List<Book> currentBookDb = bookDao.getByPropertyEqual(isbnType, isbnNumber);

            if(currentBookDb.size() > 0) {
                logger.info("The matching book found in database: {}", currentBookDb.get(0));
                newBook = currentBookDb.get(0);
                insertBook = false;
                break;
            } else {
                if(isbn.getIdentifier().length() == ISBN10_SIZE) {
                    newBook.setIsbn10(isbn.getIdentifier());
                } else if (isbn.getIdentifier().length() == ISBN13_SIZE) {
                    newBook.setIsbn13(isbn.getIdentifier());
                }

            }
        }
        if(insertBook) {
            bookDao.insert(newBook);
        }

        User user = (User) session.getAttribute("user");

        UserBookData newBookData = new UserBookData(user, newBook);

        Set<UserBookData> userBookData = (Set<UserBookData>)session.getAttribute("userBookData");
        GenericDao<UserBookData> userBookDataDao = new GenericDao<>(UserBookData.class);

        if(userBookData.add(newBookData)) {
            userBookDataDao.insert(newBookData);
        }

        session.setAttribute("userBookData", userBookData);
        session.setAttribute("userGoogleBooks", googleBooksData);
        session.setAttribute("bookResults", null);
        //todo redirect instead of forward
        RequestDispatcher dispatcher = req.getRequestDispatcher("/books.jsp");
        dispatcher.forward(req, resp);
    }
}
