package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.MappedBook;
import com.bookshelfBanshee.entity.User;
import com.bookshelfBanshee.entity.UserBookData;
import com.bookshelfBanshee.persistence.GenericDao;
import com.googlebooksapi.controller.GoogleBooksAPI;
import com.googlebooksapi.entity.IndustryIdentifiersItem;
import com.googlebooksapi.entity.VolumeInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class BookManager {
    private final Logger logger = LogManager.getLogger(this.getClass());
    // Holds the data returned form the google books api for all of a users books,
    // This needs to be refactored to only call the first 200 of a users books then
    //use pagination to call the next 200 books.

    private GoogleBooksAPI api = new GoogleBooksAPI();
    private GenericDao<User> userDao = new GenericDao(User.class);
    private GenericDao<Book> bookDao= new GenericDao<>(Book.class);
    private GenericDao<UserBookData> userBookDataDao = new GenericDao<>(UserBookData.class);
    //this class will be created after a user signs in
    // It will hold all the book data returned from the api, I need to maintain this data in the session
    // so if I need to check if a book has already been added to the session of userBooks. ie make sure I
    // append when i query for more data. if(book !in userbook call api)

    //I think pass a param in based on the page you are on ...

    public Map<Integer, MappedBook> getGoogleAPIBookData(Set<Book> userBooks, Set<UserBookData> allBookData) {
        String queryParam = "isbn";
        Map<Integer, MappedBook> mappedBooks = new HashMap<>();
        // TODO make sure to limit number of queries to 200!!!! pagination will call next set afterward
        // TODO make sure there is an ability to load new books on each page then so that if they switch to a new set
        //  of 200 books it is still loaded for the user
        for(Book book : userBooks) {
            //todo make it so it checks for isbn13 then falls back to isbn10 if there is no 13
            VolumeInfo googleBook = api.getBook(queryParam, book.getIsbn13());

            //call getBookDetails
            Set<UserBookData> eachBookData = getBookDetails(book, allBookData);
            //call it here passing data
            MappedBook thisMappedBook = new MappedBook(book.getId(), eachBookData, googleBook);
//            there is a putIfAbsent method for maps
            mappedBooks.put(book.getId(), thisMappedBook);
            logger.info("Adding books to mappedBooks: {}", mappedBooks);
        }
        return mappedBooks;

    }

    public List<VolumeInfo> searchGoogleAPIBook(String searchType, String searchTerm) {
        // the maxResults value is by default 10 books, which I think works for my program
        return  api.searchBooks(searchType, searchTerm);
    }

    public User getUser(String username) {
        return (User)userDao.getByPropertyEqual("username", username).get(0);
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

    public Book checkForExistingBook(VolumeInfo book){
        List<IndustryIdentifiersItem> isbns = book.getIndustryIdentifiers();
        Book newBook = new Book();
        final int ISBN10_SIZE = 10;
        final int ISBN13_SIZE = 13;
        String isbnType;
        String isbnNumber;

        for(IndustryIdentifiersItem isbn: isbns){
            //get the isbns from the google book
            isbnType = isbn.getType();
            isbnType = isbnType.toLowerCase().replace("_","");
            isbnNumber = isbn.getIdentifier();

            //check db to see if the book already exists
            List<Book> currentBookDb = bookDao.getByPropertyEqual(isbnType, isbnNumber);

            if(!currentBookDb.isEmpty()) {
                logger.info("The matching book found in database: {}", currentBookDb.get(0));
                //return the book if it is found
                return currentBookDb.get(0);

            } else {
                //set the isbns if it is a new book
                if(isbn.getIdentifier().length() == ISBN10_SIZE) {
                    newBook.setIsbn10(isbn.getIdentifier());
                } else if (isbn.getIdentifier().length() == ISBN13_SIZE) {
                    newBook.setIsbn13(isbn.getIdentifier());
                }

            }
        }
        //insert the new book into the database
        bookDao.insert(newBook);
        return newBook;

    }

    public boolean userHasBook(Set<UserBookData> userBookData, Book book){

        //check if the book was already in the users books
        for (UserBookData bookData: userBookData){
            if(bookData.getBook().equals(book)){
             return true;
            }
        }
        return false;
    }

    public Set<UserBookData> deleteUserBookData(Set<UserBookData> userBookData, Book currentBook) {
        Set<UserBookData> dataToDelete = new HashSet<>();
        Set<UserBookData> dataToKeep = new HashSet<>();
        for(UserBookData book: userBookData) {
            if(book.getBook().equals(currentBook)) {
                dataToDelete.add(book);

            } else {
                dataToKeep.add(book);
            }
        }

        if (!dataToDelete.isEmpty()){
            for(UserBookData bookData: dataToDelete){
                userBookDataDao.delete(bookData);
            }
            userBookData = dataToKeep;
        }
        return userBookData;
    }

    public Book getBookDB(int bookId){
        return (Book)bookDao.getById(bookId);
    }


}
