package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.MappedBook;
import com.bookshelfBanshee.entity.UserList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The type List manager.
 */
public class ListManager {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets books on list.
     *
     * @param currentList the current list
     * @return the books on list
     */
    public Set<Integer> getBooksOnList(UserList currentList) {

        Set<Book> booksOnList = currentList.getBooksOnList();
        Set<Integer> keysOfBooksOnList = new HashSet<>();
        for (Book book: booksOnList) {
            keysOfBooksOnList.add(book.getId());
        }
        logger.debug("Keys of books on list: {}", keysOfBooksOnList);

        return keysOfBooksOnList;

    }

    /**
     * Gets books not on list.
     *
     * @param mappedBooks       the mapped books
     * @param keysOfBooksOnList the keys of books on list
     * @return the books not on list
     */
    public Set<Integer> getBooksNotOnList(Map<Integer, MappedBook> mappedBooks, Set<Integer> keysOfBooksOnList) {

        Map<Integer, MappedBook> copyMappedBooks = new HashMap<>(mappedBooks);
        Set<Integer> keysOfBooksNotOnList = copyMappedBooks.keySet();
        logger.debug("Keys of all books: {}", keysOfBooksNotOnList);
        keysOfBooksNotOnList.removeAll(keysOfBooksOnList);
        logger.debug("Keys of books not on list: {}", keysOfBooksNotOnList);

        return keysOfBooksNotOnList;
    }


}
