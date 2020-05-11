package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.MappedBook;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.persistence.GenericDao;
import com.bookshelfBanshee.test.util.Database;
import com.googlebooksapi.entity.IndustryIdentifiersItem;
import com.googlebooksapi.entity.VolumeInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {
    private final Logger logger = LogManager.getLogger(this.getClass());

    GenericDao bookDao;
    GenericDao userDao;
    BookManager bookManager;


    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        bookDao = new GenericDao(Book.class);
        userDao = new GenericDao(User.class);
        bookManager = new BookManager();

    }

    @Test
    void getGoogleAPIBookData() {
        User user = (User) userDao.getById(1);
        Set<UserBookData> allBookData = user.getUserBooks();
        Set<Book> userBooks = new HashSet<>();
        for(UserBookData bookData: allBookData) {
            userBooks.add(bookData.getBook());
        }
        logger.debug(allBookData);
        logger.debug(userBooks);

        Map<Integer, MappedBook> mappedBooks = bookManager.getGoogleAPIBookData(userBooks, allBookData);

        logger.debug(mappedBooks);

        assertNotNull(mappedBooks);


    }
//
//    @Test
//    void searchGoogleAPIBook() {
//    }
//
//    @Test
//    void getBookDetails() {
//
//    }
}