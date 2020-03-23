package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.BookList;
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
        listDao = new GenericDao(BookList.class);
        userDao = new GenericDao(User.class);

    }

    @Test
    void getById() {
        BookList retrievedList = (BookList) listDao.getById(1);
        String retrievedListName = retrievedList.getName();
        assertEquals("first list", retrievedListName);
    }

    @Test
    void saveOrUpdate() {
        BookList retrievedList = (BookList) listDao.getById(1);
        String newName = "resetName";
        retrievedList.setName(newName);
        listDao.saveOrUpdate(retrievedList);
        BookList updatedList = (BookList) listDao.getById(1);
        assertEquals(retrievedList, updatedList);
    }

    @Test
    void insert() {
        User user = (User)userDao.getById(2);
        BookList list = new BookList("last list","this is the last list",user);
        listDao.insert(list);
        int allBooksSize = listDao.getAll().size();
        assertEquals(3, allBooksSize);

    }

    @Test
    void delete() {
        BookList list = (BookList) listDao.getById(1);
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