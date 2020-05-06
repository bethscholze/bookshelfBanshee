package com.bookshelfBanshee.persistence;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.UserList;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ListDaoTest {

    GenericDao bookListDao;
    GenericDao userDao;
    GenericDao bookDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        bookListDao = new GenericDao(UserList.class);
        userDao = new GenericDao(User.class);
        bookDao = new GenericDao(Book.class);

    }

    @Test
    void getById() {
        UserList retrievedList = (UserList) bookListDao.getById(1);
        String retrievedListName = retrievedList.getName();
        assertEquals("first list", retrievedListName);
    }

    @Test
    void saveOrUpdate() {
        UserList retrievedList = (UserList) bookListDao.getById(1);
        String newName = "resetName";
        Book retrievedBook = (Book) bookDao.getById(3);
        Set<Book> booksOnList = retrievedList.getBooksOnList();
        booksOnList.add(retrievedBook);
        retrievedList.setBooksOnList(booksOnList);
        retrievedList.setName(newName);
        bookListDao.saveOrUpdate(retrievedList);
        UserList updatedList = (UserList) bookListDao.getById(1);
        assertEquals(retrievedList, updatedList);
    }

    @Test
    void insert() {
        User user = (User)userDao.getById(2);
        UserList list = new UserList("last list","this is the last list",user);
        bookListDao.insert(list);
        int allBooksSize = bookListDao.getAll().size();
        assertEquals(3, allBooksSize);

    }

    @Test
    void delete() {
        UserList list = (UserList) bookListDao.getById(1);
        bookListDao.delete(list);
        int allBooksSize = bookListDao.getAll().size();
        assertEquals(1, allBooksSize);
        assertNull(bookListDao.getById(1));
        int allUsersSize = userDao.getAll().size();
        assertEquals(5, allUsersSize);
    }

    @Test
    void getAll() {
        int allListsSize = bookListDao.getAll().size();
        assertEquals(2, allListsSize);
    }
}