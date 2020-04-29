package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.Role;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.test.util.Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RoleDaoTest {

    GenericDao roleDao;
    GenericDao userDao;
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        roleDao = new GenericDao(Role.class);
        userDao = new GenericDao(User.class);

    }

    @Test
    void getById() {
        Role retrievedUserRole = (Role)roleDao.getById(1);
        assertNotNull(retrievedUserRole);
        User retrievedUser = (User)retrievedUserRole.getUser();
        assertEquals("me", retrievedUser.getUsername());
        assertEquals("administrator", retrievedUserRole.getRole());
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void insert() {
        User newUser = new User();
        newUser.setUsername("newUser");
        newUser.setPassword("newPassword");
        userDao.insert(newUser);
        Role newRole = new Role();
        newRole.setUser(newUser);
        newRole.setRole("user");
        roleDao.insert(newRole);
        assertNotNull(newUser);
        assertNotNull(newRole);
        assertEquals("newUser", newRole.getUser().getUsername());
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
        int getAllSize = roleDao.getAll().size();
        assertEquals(2, getAllSize);
    }
}