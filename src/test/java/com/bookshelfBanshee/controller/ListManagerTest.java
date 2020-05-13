package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.*;
import com.bookshelfBanshee.persistence.GenericDao;
import com.bookshelfBanshee.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {

    GenericDao userDao;
    ListManager listManager;
    BookManager bookManager;
    User user;
    List<UserList> userLists;
    UserList currentList;
    Set<UserBookData> allBookData;
    Set<Book> userBooks;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new GenericDao(User.class);
        listManager = new ListManager();
        bookManager = new BookManager();
        user = (User) userDao.getById(1);
        userLists = user.getLists();
        currentList = userLists.get(0);
        allBookData = user.getUserBooks();
        userBooks = new HashSet<>();
        for(UserBookData bookData: allBookData) {
            userBooks.add(bookData.getBook());
        }

    }

    @Test
    void getBooksOnList() {
        Set<Integer> keysOfBooks = listManager.getBooksOnList(currentList);
        assertEquals(2, keysOfBooks.size());
    }

    @Test
    void getBooksNotOnList() {
        Set<Integer> keysOfBooksOn = listManager.getBooksOnList(currentList);
        Map<Integer, MappedBook> mappedBooks = bookManager.getGoogleAPIBookData(userBooks, allBookData);
        Set<Integer> keysOfBooksOff = listManager.getBooksNotOnList(mappedBooks, keysOfBooksOn);

        assertEquals(0, keysOfBooksOff.size());
    }
}