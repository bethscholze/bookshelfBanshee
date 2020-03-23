package com.googlebooksapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class GoogleBooksAPI {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public String createClient(String queryParam, String isbn) {
        Client client = ClientBuilder.newClient();
        //https://www.googleapis.com/books/v1/volumes?q=isbn:9781250313188
        WebTarget target = client.target("https://www.googleapis.com/books/v1/volumes?q=" + queryParam + ":" + isbn);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        return response;
    }
    public VolumeInfo getBook(String queryParam, String isbn) {
        String response = createClient(queryParam, isbn);

        ObjectMapper mapper = new ObjectMapper();
        VolumeInfo volumeInfo = new VolumeInfo();
        try {
            BookResponse mappedResponse = mapper.readValue(response, BookResponse.class);
            ItemsItem item = mappedResponse.getItems().get(0);
            volumeInfo = item.getVolumeInfo();
            // TODO create dao to call your service and have different functions for each call you need
        } catch (JsonProcessingException e) {
            logger.error("couldnt create object from given json data");
        }

        return volumeInfo;
    }


}
