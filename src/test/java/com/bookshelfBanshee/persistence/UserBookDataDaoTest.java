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
    GenericDao userBookDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userBookDataDao = new GenericDao(UserBookData.class);
        userDao = new GenericDao(User.class);
        userBookDao = new GenericDao(Book.class);

    }

@Test
    void getById() {
        UserBookData userBookData = (UserBookData)userBookDataDao.getById(1);
        Book retrievedBook = (Book) userBookDao.getById(1);
        assertEquals(retrievedBook, userBookData.getBook());
    }
    @Test
    void saveOrUpdate() {
        UserBookData retrievedBookData = (UserBookData) userBookDataDao.getById(1);
        String dataLabel = "own, rent, borrow, buy";
        String dataValue = "own";
        retrievedBookData.setDataLabel(dataLabel);
        retrievedBookData.setDataValue(dataValue);
        userBookDataDao.saveOrUpdate(retrievedBookData);
        UserBookData updatedBookData = (UserBookData) userBookDataDao.getById(1);
        assertEquals(retrievedBookData, updatedBookData);
    }

    @Test
    void insert() {
        User user = (User)userDao.getById(2);
        Book book = new Book("125031318X","9781250313188");
        userBookDataDao.insert(book);
        int allBooksSize = userBookDataDao.getAll().size();
        assertEquals(3, allBooksSize);

    }

    @Test
    void delete() {
        UserBookData bookData = (UserBookData) userBookDataDao.getById(1);
        userBookDataDao.delete(bookData);
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