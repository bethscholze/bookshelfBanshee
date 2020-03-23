package com.googlebooksapi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.googlebooksapi.GoogleBooksAPI;
import com.googlebooksapi.VolumeInfo;

class GoogleBooksAPITest {

    @Test
    void getBook() {
        GoogleBooksAPI googleBooksAPI = new GoogleBooksAPI();
        String queryParam = "isbn";
        String isbn = "9781250313188";
        VolumeInfo volumeInfo = googleBooksAPI.getBook(queryParam, isbn);
        String expectedTitle = "Gideon the Ninth";
        assertEquals(expectedTitle, volumeInfo.getTitle());
    }
}