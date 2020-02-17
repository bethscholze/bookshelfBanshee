package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    @BeforeEach
    void setUp() {
        edu.matc.test.util.Database database = edu.matc.test.util.Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new UserDao();
    }

    @Test
    void getById() {
        User retrievedUser = dao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("notAdmin", retrievedUser.getUsername());
    }

    @Test
    void saveOrUpdate() {
        User retrievedUser = dao.getById(1);
        retrievedUser.setUsername("resetUsername");
        dao.saveOrUpdate(retrievedUser);
        User updatedUser = dao.getById(1);
        assertEquals("resetUsername", updatedUser.getUsername());
    }

    @Test
    void insert() {
        User user = new User("newUser", "newPassword");
        dao.insert(user);
        int allUsersSize = dao.getAll().size();
        assertEquals(6, allUsersSize);
    }

    @Test
    void delete() {
        User user = dao.getById(1);
        dao.delete(user);
        int allUsersSize = dao.getAll().size();
        assertEquals(4, allUsersSize);
    }

    @Test
    void getAll() {
        int getAllSize = dao.getAll().size();
        assertEquals(5, getAllSize);
    }
}