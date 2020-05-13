package com.googlebooksapi.controller;

import com.bookshelfBanshee.utilities.PropertiesLoader;
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
import java.util.Properties;

/**
 * The type Google books api.
 */
public class GoogleBooksAPI implements PropertiesLoader{
    private final Logger logger = LogManager.getLogger(this.getClass());
    private Properties properties = loadProperties("/bookshelfBanshee.properties");;

    /**
     * Create client string.
     *
     * @param queryParam the query param
     * @param searchTerm the search term
     * @return the string
     */
    public String createClient(String queryParam, String searchTerm) {
        Client client = ClientBuilder.newClient();

        logger.info(properties.getProperty("urlForApi") + "{}:{}", queryParam, searchTerm);
        WebTarget target = client.target( properties.getProperty("urlForApi")+ queryParam + ":" + searchTerm + "&country=US");
        logger.info("url for request: {}", target);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        logger.info("The response from the api: {}", response);

        return response;
    }

    /**
     * Gets book.
     *
     * @param queryParam the query param
     * @param searchTerm the search term
     * @return the book
     */
    public VolumeInfo getBook(String queryParam, String searchTerm) {
        String response = createClient(queryParam, searchTerm);

        /*
        there is a bug in the google books api, where sometimes it returns no data for an isbn #
        depending on whether "isbn" is lowercase or uppercase. Everyone said that this is why they used the goodReads
        api instead
         */
        final int MIN_VOLUME_INFO_LENGTH = 50;
        if(response.length() < MIN_VOLUME_INFO_LENGTH) {
            queryParam = queryParam.toUpperCase();
            response = createClient(queryParam, searchTerm);
        }
        ObjectMapper mapper = new ObjectMapper();
        VolumeInfo volumeInfo = new VolumeInfo();
        try {
            BookResponse mappedResponse = mapper.readValue(response, BookResponse.class);
            ItemsItem item = mappedResponse.getItems().get(0);
            volumeInfo = item.getVolumeInfo();
            logger.info("The VolumeInfo Item: {}", volumeInfo);
        } catch (JsonProcessingException e) {
            logger.error("Couldnt create object from given json data. The ");
        } catch (NullPointerException nullException){
            logger.error("The api did not return a value for this isbn.");
        }

        return volumeInfo;
    }

    /**
     * Search books list.
     *
     * @param queryParam the query param
     * @param searchTerm the search term
     * @return the list
     */
    public List<VolumeInfo> searchBooks(String queryParam, String searchTerm) {
        String response = createClient(queryParam, searchTerm);
        ObjectMapper mapper = new ObjectMapper();
        List<VolumeInfo> volumeInfoList = new ArrayList<>();
        try {
            BookResponse mappedResponse = mapper.readValue(response, BookResponse.class);
            List<ItemsItem> bookResults = mappedResponse.getItems();
            logger.info(bookResults.size());
            for(int i = 0; i < bookResults.size(); i++) {
                ItemsItem item = bookResults.get(i);
                VolumeInfo volumeInfo = item.getVolumeInfo();
                volumeInfoList.add(volumeInfo);
                logger.info("The VolumeInfo Item: {}", volumeInfo);
            }

        } catch (JsonProcessingException e) {
            logger.error("couldn't create object from given json data");
        }

        return volumeInfoList;
    }




}
