package com.bookshelfBanshee.controller;

import com.bookshelfBanshee.entity.Book;
import com.bookshelfBanshee.entity.UserBookData;
import com.googlebooksapi.GoogleBooksAPI;
import com.googlebooksapi.VolumeInfo;

import java.util.HashSet;
import java.util.Set;

public class BookManager {
    //this class will be created after a user signs in
    //it will need to create a bookFactory to create all the book objects for a user
    //this will also create the bookDao?

    public Set<VolumeInfo> getGoogleAPIBookData(Set<UserBookData> userBooks) throws Exception {
        GoogleBooksAPI api = new GoogleBooksAPI();
        Set<VolumeInfo> returnedBookInfo = new HashSet<>();
        for(UserBookData bookData : userBooks) {
            VolumeInfo book = api.getBook(bookData.getBook().getIsbn13());
            returnedBookInfo.add(book);
        }
        return returnedBookInfo;

    }


}
