package com.googlebooksapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlebooksapi.entity.BookResponse;
import com.googlebooksapi.entity.ItemsItem;
import com.googlebooksapi.entity.VolumeInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

public class GoogleBooksAPI {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public String createClient(String queryParam, String searchType) {
        Client client = ClientBuilder.newClient();
        //https://www.googleapis.com/books/v1/volumes?q=isbn:9781250313188
        WebTarget target = client.target("https://www.googleapis.com/books/v1/volumes?q=" + queryParam + ":" + searchType);
        logger.info("url for request: {}", target);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.info("The response from the api: {}", response);
        return response;
    }
    public VolumeInfo getBook(String queryParam, String searchType) {
        String response = createClient(queryParam, searchType);

        ObjectMapper mapper = new ObjectMapper();
        VolumeInfo volumeInfo = new VolumeInfo();
        try {
            BookResponse mappedResponse = mapper.readValue(response, BookResponse.class);
            ItemsItem item = mappedResponse.getItems().get(0);
            volumeInfo = item.getVolumeInfo();
            logger.info("The VolumeInfo Item: {}", volumeInfo);
            // TODO create dao to call your service and have different functions for each call you need
        } catch (JsonProcessingException e) {
            logger.error("couldnt create object from given json data");
        }

        return volumeInfo;
    }

    public List<VolumeInfo> searchBooks(String queryParam, String searchType) {
        String response = createClient(queryParam, searchType);
        ObjectMapper mapper = new ObjectMapper();
        List<VolumeInfo> volumeInfoList = new ArrayList<>();
        try {
            BookResponse mappedResponse = mapper.readValue(response, BookResponse.class);
            for(int i = 0; i < mappedResponse.getTotalItems() || i < 10; i++) {
                ItemsItem item = mappedResponse.getItems().get(i);
                VolumeInfo volumeInfo = item.getVolumeInfo();
                volumeInfoList.add(volumeInfo);
                logger.info("The VolumeInfo Item: {}", volumeInfo);
            }

        } catch (JsonProcessingException e) {
            logger.error("couldnt create object from given json data");
        }

        return volumeInfoList;
    }




}
