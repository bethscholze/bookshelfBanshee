package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.UserBookData;
import com.googlebooksapi.GoogleBooksAPI;
import com.googlebooksapi.VolumeInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookManager {
    // Holds the data returned form the google books api for all of a users books,
    // This needs to be refactored to only call the first 200 of a users books then
    //use pagination to call the next 200 books.
    private List<VolumeInfo> returnedBookInfo = new ArrayList<>();
    //this class will be created after a user signs in
    // It will hold all the book data returned from the api, I need to maintain this data in the session
    // so if I need to check if a book has already been added to the session of userBooks. ie make sure I
    // append when i query for more data. if(book !in userbook call api)

    //I think pass a param in based on the page you are on ...

    public List<VolumeInfo> getGoogleAPIBookData(Set<UserBookData> userBooks) {
        GoogleBooksAPI api = new GoogleBooksAPI();
        String queryParam = "isbn";
        // TODO make sure to limit number of queries to 200!!!! pagination will call next set afterward
        // TODO make sure there is an ability to load new books on each page then so that if they switch to a new set
        //  of 200 books it is still loaded for the user
        for(UserBookData bookData : userBooks) {
            VolumeInfo book = api.getBook(queryParam, bookData.getBook().getIsbn13());

            returnedBookInfo.add(book);
        }
        return returnedBookInfo;

    }


}
