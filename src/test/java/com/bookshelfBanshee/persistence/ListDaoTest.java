package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.UserList;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ListDaoTest {

    GenericDao listDao;
    GenericDao userDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        listDao = new GenericDao(UserList.class);
        userDao = new GenericDao(User.class);

    }

    @Test
    void getById() {
        UserList retrievedList = (UserList) listDao.getById(1);
        String retrievedListName = retrievedList.getName();
        assertEquals("first list", retrievedListName);
    }

    @Test
    void saveOrUpdate() {
        UserList retrievedList = (UserList) listDao.getById(1);
        String newName = "resetName";
        retrievedList.setName(newName);
        listDao.saveOrUpdate(retrievedList);
        UserList updatedList = (UserList) listDao.getById(1);
        assertEquals(retrievedList, updatedList);
    }

    @Test
    void insert() {
        User user = (User)userDao.getById(2);
        UserList list = new UserList("last list","this is the last list",user);
        listDao.insert(list);
        int allBooksSize = listDao.getAll().size();
        assertEquals(3, allBooksSize);

    }

    @Test
    void delete() {
        UserList list = (UserList) listDao.getById(1);
        listDao.delete(list);
        int allBooksSize = listDao.getAll().size();
        assertEquals(1, allBooksSize);
        assertNull(listDao.getById(1));
        int allUsersSize = userDao.getAll().size();
        assertEquals(5, allUsersSize);
    }

    @Test
    void getAll() {
        int allListsSize = listDao.getAll().size();
        assertEquals(2, allListsSize);
    }
}