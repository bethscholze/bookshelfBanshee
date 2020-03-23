package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {

    GenericDao bookDao;
    GenericDao userDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        bookDao = new GenericDao(Book.class);
        userDao = new GenericDao(User.class);

    }

    @Test
    void getById() {
        Book retrievedBook = (Book) bookDao.getById(1);
        String retrievedIsbn = retrievedBook.getIsbn13();
        assertEquals("9781250313188", retrievedIsbn);
    }

    @Test
    void saveOrUpdate() {
        Book retrievedBook = (Book) bookDao.getById(1);
        String newIsbn = "resetIsbn";
        retrievedBook.setIsbn13(newIsbn);
        bookDao.saveOrUpdate(retrievedBook);
        Book updatedBook = (Book) bookDao.getById(1);
        assertEquals(retrievedBook, updatedBook);
    }

    @Test
    void insert() {
        User user = (User)userDao.getById(2);
        Book book = new Book("125031318X","9781250313188");
        bookDao.insert(book);
        int allBooksSize = bookDao.getAll().size();
        assertEquals(4, allBooksSize);

    }

    @Test
    void delete() {
        Book book = (Book) bookDao.getById(1);
        bookDao.delete(book);
        int allBooksSize = bookDao.getAll().size();
        assertEquals(2, allBooksSize);
        assertNull(bookDao.getById(1));
        int allUsersSize = userDao.getAll().size();
        assertEquals(5, allUsersSize);
    }

    @Test
    void getAll() {
        int allBooksSize = bookDao.getAll().size();
        assertEquals(3, allBooksSize);
    }
}