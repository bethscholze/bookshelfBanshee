package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.UserBookData;
import com.googlebooksapi.GoogleBooksAPI;

import java.util.Set;

public class BookManager {
    //this class will be created after a user signs in
    //it will need to create a bookFactory to create all the book objects for a user
    //this will also create the bookDao?

    public ApiBooks getGoogleAPIBookData(Set<UserBookData> userBooks) throws Exception {
        GoogleBooksAPI api = new GoogleBooksAPI();
        Set<ApiBooks> returnedBooks;
        for(UserBookData bookData : userBooks) {
            ApiBook book = api.getBook(bookData.getBook().getIsbn13());
            returnedBooks.add(book);
        }
        return returnedBooks;

    }


}
