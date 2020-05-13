package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.MappedBook;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.persistence.GenericDao;
import com.bookshelfBanshee.test.util.Database;
import com.googlebooksapi.entity.VolumeInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao bookDao;
    GenericDao userDao;
    GenericDao userBookDataDao;
    BookManager bookManager;
    User user;
    Set<UserBookData> allBookData;
    Set<Book> userBooks;


    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        bookDao = new GenericDao(Book.class);
        userDao = new GenericDao(User.class);
        userBookDataDao = new GenericDao(UserBookData.class);
        bookManager = new BookManager();
        user = (User) userDao.getById(1);
        allBookData = user.getUserBooks();
        userBooks = new HashSet<>();
        for(UserBookData bookData: allBookData) {
            userBooks.add(bookData.getBook());
        }

    }

    @Test
    void getGoogleAPIBookData() {
        Map<Integer, MappedBook> mappedBooks = bookManager.getGoogleAPIBookData(userBooks, allBookData);

        logger.debug(mappedBooks);

        assertNotNull(mappedBooks);
        assertTrue(mappedBooks.containsKey(2));
        assertTrue(mappedBooks.containsKey(3));
    }

    @Test
    void searchGoogleAPIBook() {
        String searchType = "title";
        String searchTerm = "name+of+the+wind";
        List<VolumeInfo> bookResults = bookManager.searchGoogleAPIBook(searchType, searchTerm);
        assertTrue(bookResults.size() == 10);
    }


    @Test
    void checkForExistingBookFound() {
        String searchType = "isbn";
        String searchTerm = "9781781084496";
        List<VolumeInfo> bookResults = bookManager.searchGoogleAPIBook(searchType, searchTerm);
        VolumeInfo apiResult = bookResults.get(0);
        Book returnedBook = bookManager.checkForExistingBook(apiResult);
        assertTrue(userBooks.contains(returnedBook));

    }
    @Test
    void checkForExistingBookNotFound() {
        String searchType = "isbn";
        String searchTerm = "9780756404741";
        List<VolumeInfo> bookResults = bookManager.searchGoogleAPIBook(searchType, searchTerm);
        VolumeInfo apiResult = bookResults.get(0);
        Book returnedBook = bookManager.checkForExistingBook(apiResult);
        assertFalse(userBooks.contains(returnedBook));
    }
    @Test
    void deleteUserBookData() throws InterruptedException {
        int allBooksSizeOld = userBookDataDao.getAll().size();
        Book currentBook = bookManager.getBookDB(2);
        logger.debug("This is all of the users book data to start: {}", allBookData);
        Set<UserBookData> currentBookData = bookManager.getBookDetails(currentBook, allBookData);
        logger.debug("This is the book I am deleting: {}", currentBookData);
        bookManager.deleteUserBookData(currentBookData);
        TimeUnit.SECONDS.sleep(10);
        //logger.debug("This is all of the users book data at the end: {}", newBookData);
        int allBooksSize = userBookDataDao.getAll().size();

        assertEquals(allBooksSizeOld - 1, allBooksSize);

    }
}