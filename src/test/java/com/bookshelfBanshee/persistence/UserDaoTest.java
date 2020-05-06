package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    GenericDao userDao;
    GenericDao bookDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        //you pass in the object.class as the type
        userDao = new GenericDao(User.class);
        bookDao = new GenericDao(Book.class);

    }

    @Test
    void getById() {
        //will need to cast for a bunch of these
        User retrievedUser = (User) userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("notAdmin", retrievedUser.getUsername());
    }

    @Test
    void saveOrUpdate() {
        //TODO fix this to work with username
        User retrievedUser = (User) userDao.getById(1);
        String newPassword = "resetPassword";
        retrievedUser.setUsername(newPassword);
        userDao.saveOrUpdate(retrievedUser);
        User updatedUser = (User) userDao.getById(1);
        assertEquals(retrievedUser, updatedUser);
    }

    @Test
    void insert() {
        User user = new User("newUser", "newPassword");
        userDao.insert(user);
        int allUsersSize = userDao.getAll().size();
        assertEquals(6, allUsersSize);
    }

    @Test
    void delete() {
        User user = (User) userDao.getById(2);
        userDao.delete(user);
        int allUsersSize = userDao.getAll().size();
        assertEquals(4, allUsersSize);
        assertNull(userDao.getById(2));
        int allBooksSize = bookDao.getAll().size();
        assertEquals(3, allBooksSize);
    }

    @Test
    void getAll() {
        int getAllSize = userDao.getAll().size();
        assertEquals(5, getAllSize);
    }

    @Test
    void getAllBooks(){
        User user = (User) userDao.getById(1);
        Set<UserBookData> books = user.getUserBooks();
        int booksSize = books.size();
        assertEquals(2, booksSize);
    }
}