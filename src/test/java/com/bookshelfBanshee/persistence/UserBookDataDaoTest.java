package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserBookDataDaoTest {
// TODO fix this class I just copy and pasted, The tests aren't testing the right thing i think
    GenericDao userBookDataDao;
    GenericDao userDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userBookDataDao = new GenericDao(UserBookData.class);
        userDao = new GenericDao(User.class);

    }

    @Test
    void getById() {
        Book retrievedBook = (Book) userBookDataDao.getById(1);
        String retrievedTitle = retrievedBook.getTitle();
        assertEquals("Gideon the Ninth", retrievedTitle);
    }

    @Test
    void saveOrUpdate() {
        Book retrievedBook = (Book) userBookDataDao.getById(1);
        String newTitle = "resetTitle";
        retrievedBook.setTitle(newTitle);
        userBookDataDao.saveOrUpdate(retrievedBook);
        Book updatedBook = (Book) userBookDataDao.getById(1);
        assertEquals(retrievedBook, updatedBook);
    }

    @Test
    void insert() {
        User user = (User)userDao.getById(2);
        Book book = new Book("125031318X","9781250313188","Gideon the Ninth","Tamsyn Muir");
        userBookDataDao.insert(book);
        int allBooksSize = userBookDataDao.getAll().size();
        assertEquals(4, allBooksSize);

    }

    @Test
    void delete() {
        Book book = (Book) userBookDataDao.getById(1);
        userBookDataDao.delete(book);
        int allBooksSize = userBookDataDao.getAll().size();
        assertEquals(2, allBooksSize);
        assertNull(userBookDataDao.getById(1));
        int allUsersSize = userDao.getAll().size();
        assertEquals(5, allUsersSize);
    }

    @Test
    void getAll() {
        int allBooksSize = userBookDataDao.getAll().size();
        assertEquals(3, allBooksSize);
    }
}