package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    //UserDao dao;
    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        //dao = new UserDao();
        //you pass in the object.class as the type
        genericDao = new GenericDao(User.class);

    }

    @Test
    void getById() {
        //will need to cast for a bunch of these
        User retrievedUser = (User)genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("notAdmin", retrievedUser.getUsername());
    }

    @Test
    void saveOrUpdate() {
        User retrievedUser = (User)genericDao.getById(1);
        String newUsername = "resetUsername";
        retrievedUser.setUsername(newUsername);
        genericDao.saveOrUpdate(retrievedUser);
        User updatedUser = (User)genericDao.getById(1);
        assertEquals(retrievedUser, updatedUser);
    }

    @Test
    void insert() {
        User user = new User("newUser", "newPassword");
        genericDao.insert(user);
        int allUsersSize =genericDao.getAll().size();
        assertEquals(6, allUsersSize);
    }

    @Test
    void delete() {
        User user = (User)genericDao.getById(1);
        genericDao.delete(user);
        int allUsersSize = genericDao.getAll().size();
        assertEquals(4, allUsersSize);
        assertNull(genericDao.getById(1));
    }

    @Test
    void getAll() {
        int getAllSize = genericDao.getAll().size();
        assertEquals(5, getAllSize);
    }
}