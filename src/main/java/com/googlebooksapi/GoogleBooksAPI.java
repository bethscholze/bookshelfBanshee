package com.googlebooksapi;

import com.bookshelfBanshee.entity.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class GoogleBooksAPI {
    private final Logger logger = LogManager.getLogger(this.getClass());
    public ApiBook getBook(String isbn) {
        Client client = ClientBuilder.newClient();
        //https://www.googleapis.com/books/v1/volumes?q=isbn:9781250313188
        WebTarget target = client.target("https://www.googleapis.com/books/v1/volumes?q=isbn:" + isbn);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        try {
            ApiBook book = mapper.readValue(response, ApiBook.class);

            // TODO create dao to call your service and have different functions for each call you need
        } catch (JsonProcessingException e) {
            logger.error("couldnt create object from given json data");
        }
        return book;
    }


}
