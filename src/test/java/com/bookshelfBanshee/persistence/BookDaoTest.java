package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {

    GenericDao genericDao;
    GenericDao userDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        genericDao = new GenericDao(Book.class);
        userDao = new GenericDao(User.class);

    }

    @Test
    void getById() {
        Book retrievedBook = (Book)genericDao.getById(1);
        String retrievedTitle = retrievedBook.getTitle();
        assertEquals("Gideon the Ninth", retrievedTitle);
    }

    @Test
    void saveOrUpdate() {
        Book retrievedBook = (Book)genericDao.getById(1);
        String newTitle = "resetTitle";
        retrievedBook.setTitle(newTitle);
        genericDao.saveOrUpdate(retrievedBook);
        Book updatedBook = (Book)genericDao.getById(1);
        assertEquals(retrievedBook, updatedBook);
    }

    @Test
    void insert() {
        User user = (User)userDao.getById(2);
        Book book = new Book("125031318X","9781250313188","Gideon the Ninth","Tamsyn Muir", user);
        genericDao.insert(book);
        int allBooksSize =genericDao.getAll().size();
        assertEquals(4, allBooksSize);
    }

    @Test
    void delete() {
        Book book = (Book)genericDao.getById(1);
        genericDao.delete(book);
        int allBooksSize = genericDao.getAll().size();
        assertEquals(2, allBooksSize);
        assertNull(genericDao.getById(1));
        int allUsersSize = userDao.getAll().size();
        assertEquals(5, allUsersSize);
    }

    @Test
    void getAll() {
        int allBooksSize =genericDao.getAll().size();
        assertEquals(3, allBooksSize);
    }
}