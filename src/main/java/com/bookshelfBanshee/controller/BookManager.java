package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.persistence.GenericDao;
import com.googlebooksapi.controller.GoogleBooksAPI;
import com.googlebooksapi.entity.VolumeInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookManager {
    private final Logger logger = LogManager.getLogger(this.getClass());
    // Holds the data returned form the google books api for all of a users books,
    // This needs to be refactored to only call the first 200 of a users books then
    //use pagination to call the next 200 books.

    private GoogleBooksAPI api = new GoogleBooksAPI();
    private GenericDao userDao = new GenericDao(User.class);
    private GenericDao<Book> bookDao= new GenericDao<>(Book.class);
    private GenericDao<UserBookData> userBookDataDao = new GenericDao<>(UserBookData.class);
    //this class will be created after a user signs in
    // It will hold all the book data returned from the api, I need to maintain this data in the session
    // so if I need to check if a book has already been added to the session of userBooks. ie make sure I
    // append when i query for more data. if(book !in userbook call api)

    //I think pass a param in based on the page you are on ...

    public List<VolumeInfo> getGoogleAPIBookData(Set<Book> userBooks) {
        List<VolumeInfo> returnedBookInfo = new ArrayList<>();
        String queryParam = "isbn";
        // TODO make sure to limit number of queries to 200!!!! pagination will call next set afterward
        // TODO make sure there is an ability to load new books on each page then so that if they switch to a new set
        //  of 200 books it is still loaded for the user
        for(Book book : userBooks) {
            //todo make it so it checks for isbn13 then falls back to isbn10 if there is no 13
            VolumeInfo googleBook = api.getBook(queryParam, book.getIsbn13());

            returnedBookInfo.add(googleBook);
        }
        return returnedBookInfo;

    }

    public List<VolumeInfo> searchGoogleAPIBook(String searchType, String searchTerm) {
        // the maxResults value is by default 10 books, which I think works for my program
        return  api.searchBooks(searchType, searchTerm);
    }

    public User getUser(String username) {
        return (User)userDao.getByPropertyEqual("username", username).get(0);
    }

    public Book getBookFromDatabase(VolumeInfo currentBookGoogle) {
        String isbnType = currentBookGoogle.getIndustryIdentifiers().get(0).getType();
        isbnType = isbnType.toLowerCase().replace("_","");
        logger.debug(isbnType);
        String isbnNumber = currentBookGoogle.getIndustryIdentifiers().get(0).getIdentifier();
        List<Book> currentBookDbList = bookDao.getByPropertyEqual(isbnType, isbnNumber);
       return currentBookDbList.get(0);
    }

    public Set<UserBookData> getBookDetails(Book currentBook, Set<UserBookData> userBookData) {
        Set<UserBookData> currentBookData = new HashSet<UserBookData>();
        for (UserBookData bookData: userBookData) {
            Book bookDataBook = bookData.getBook();
            logger.debug(bookDataBook);
            if (bookDataBook.equals(currentBook)) {
                currentBookData.add(bookData);
            }
        }
        return currentBookData;
    }

}
