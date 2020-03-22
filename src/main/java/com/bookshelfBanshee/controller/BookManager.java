package com.bookshelfBanshee.controller;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class BookManager {
    //this class will be created after a user signs in
    //it will need to create a bookFactory to create all the book objects for a user
    //this will also create the bookDao?

    /*
    foreach {Book book on booklist}

    public void getGoogleAPIBook() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://googlebooks....");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        try {
            book = mapper.readValue(response, Book.class);

            // TODO create dao to call your service and have different functions for each call you need
        } catch (JsonProcessingException e) {
            logger.error("couldnt create object from given json data");
        }
        return book;

    }

     */
}
