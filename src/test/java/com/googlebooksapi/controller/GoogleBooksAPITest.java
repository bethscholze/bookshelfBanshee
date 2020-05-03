package com.googlebooksapi.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.googlebooksapi.controller.GoogleBooksAPI;
import com.googlebooksapi.entity.VolumeInfo;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;

class GoogleBooksAPITest {
    String jsonResponseBook = "{\n" +
            " \"kind\": \"books#volumes\",\n" +
            " \"totalItems\": 1,\n" +
            " \"items\": [\n" +
            "  {\n" +
            "   \"kind\": \"books#volume\",\n" +
            "   \"id\": \"Wgi8yAEACAAJ\",\n" +
            "   \"etag\": \"6xUEmsWCT9c\",\n" +
            "   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/Wgi8yAEACAAJ\",\n" +
            "   \"volumeInfo\": {\n" +
            "    \"title\": \"Gideon the Ninth\",\n" +
            "    \"authors\": [\n" +
            "     \"Tamsyn Muir\"\n" +
            "    ],\n" +
            "    \"publisher\": \"Tor.com\",\n" +
            "    \"publishedDate\": \"2020-05-19\",\n" +
            "    \"description\": \"A USA Today Best-Selling Novel, and one of the Best Books of 2019 according to NPR, the New York Public Library, Amazon, BookPage, Shelf Awareness, BookRiot, and Bustle! “Unlike anything I’ve ever read. ” —V.E. Schwab “Lesbian necromancers explore a haunted gothic palace in space!” —Charles Stross “Deft, tense and atmospheric, compellingly immersive and wildly original.” —The New York Times The Emperor needs necromancers. The Ninth Necromancer needs a swordswoman. Gideon has a sword, some dirty magazines, and no more time for undead nonsense. Tamsyn Muir’s Gideon the Ninth unveils a solar system of swordplay, cut-throat politics, and lesbian necromancers. Her characters leap off the page, as skillfully animated as arcane revenants. The result is a heart-pounding epic science fantasy. Brought up by unfriendly, ossifying nuns, ancient retainers, and countless skeletons, Gideon is ready to abandon a life of servitude and an afterlife as a reanimated corpse. She packs up her sword, her shoes, and her dirty magazines, and prepares to launch her daring escape. But her childhood nemesis won’t set her free without a service. Harrowhark Nonagesimus, Reverend Daughter of the Ninth House and bone witch extraordinaire, has been summoned into action. The Emperor has invited the heirs to each of his loyal Houses to a deadly trial of wits and skill. If Harrowhark succeeds she will be become an immortal, all-powerful servant of the Resurrection, but no necromancer can ascend without their cavalier. Without Gideon’s sword, Harrow will fail, and the Ninth House will die. Of course, some things are better left dead. THE LOCKED TOMB TRILOGY BOOK 1: Gideon the Ninth BOOK 2: Harrow the Ninth BOOK 3: Alecto the Ninth\",\n" +
            "    \"industryIdentifiers\": [\n" +
            "     {\n" +
            "      \"type\": \"ISBN_10\",\n" +
            "      \"identifier\": \"125031318X\"\n" +
            "     },\n" +
            "     {\n" +
            "      \"type\": \"ISBN_13\",\n" +
            "      \"identifier\": \"9781250313188\"\n" +
            "     }\n" +
            "    ],\n" +
            "    \"readingModes\": {\n" +
            "     \"text\": false,\n" +
            "     \"image\": false\n" +
            "    },\n" +
            "    \"pageCount\": 480,\n" +
            "    \"printType\": \"BOOK\",\n" +
            "    \"categories\": [\n" +
            "     \"Fiction\"\n" +
            "    ],\n" +
            "    \"averageRating\": 5.0,\n" +
            "    \"ratingsCount\": 1,\n" +
            "    \"maturityRating\": \"NOT_MATURE\",\n" +
            "    \"allowAnonLogging\": false,\n" +
            "    \"contentVersion\": \"preview-1.0.0\",\n" +
            "    \"panelizationSummary\": {\n" +
            "     \"containsEpubBubbles\": false,\n" +
            "     \"containsImageBubbles\": false\n" +
            "    },\n" +
            "    \"imageLinks\": {\n" +
            "     \"smallThumbnail\": \"http://books.google.com/books/content?id=Wgi8yAEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api\",\n" +
            "     \"thumbnail\": \"http://books.google.com/books/content?id=Wgi8yAEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api\"\n" +
            "    },\n" +
            "    \"language\": \"en\",\n" +
            "    \"previewLink\": \"http://books.google.com/books?id=Wgi8yAEACAAJ&dq=isbn:9781250313188&hl=&cd=1&source=gbs_api\",\n" +
            "    \"infoLink\": \"http://books.google.com/books?id=Wgi8yAEACAAJ&dq=isbn:9781250313188&hl=&source=gbs_api\",\n" +
            "    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Gideon_the_Ninth.html?hl=&id=Wgi8yAEACAAJ\"\n" +
            "   },\n" +
            "   \"saleInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"saleability\": \"NOT_FOR_SALE\",\n" +
            "    \"isEbook\": false\n" +
            "   },\n" +
            "   \"accessInfo\": {\n" +
            "    \"country\": \"US\",\n" +
            "    \"viewability\": \"NO_PAGES\",\n" +
            "    \"embeddable\": false,\n" +
            "    \"publicDomain\": false,\n" +
            "    \"textToSpeechPermission\": \"ALLOWED\",\n" +
            "    \"epub\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"pdf\": {\n" +
            "     \"isAvailable\": false\n" +
            "    },\n" +
            "    \"webReaderLink\": \"http://play.google.com/books/reader?id=Wgi8yAEACAAJ&hl=&printsec=frontcover&source=gbs_api\",\n" +
            "    \"accessViewStatus\": \"NONE\",\n" +
            "    \"quoteSharingAllowed\": false\n" +
            "   },\n" +
            "   \"searchInfo\": {\n" +
            "    \"textSnippet\": \"Without Gideon’s sword, Harrow will fail, and the Ninth House will die. Of course, some things are better left dead. THE LOCKED TOMB TRILOGY BOOK 1: Gideon the Ninth BOOK 2: Harrow the Ninth BOOK 3: Alecto the Ninth\"\n" +
            "   }\n" +
            "  }\n" +
            " ]\n" +
            "}";
    @Test
    void createClient() {
        Client client = ClientBuilder.newClient();
        String queryParam = "isbn";
        String queryTerm = "9781250313188";
        //https://www.googleapis.com/books/v1/volumes?q=isbn:9781250313188
        WebTarget target = client.target("https://www.googleapis.com/books/v1/volumes?q=" + queryParam + ":" + queryTerm);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class).trim();
        assertEquals(jsonResponseBook,response);
    }

    @Test
    void getBook() {
        GoogleBooksAPI googleBooksAPI = new GoogleBooksAPI();
        String queryParam = "isbn";
        String isbn = "9781250313188";
        VolumeInfo volumeInfo = googleBooksAPI.getBook(queryParam, isbn);
        String expectedTitle = "Gideon the Ninth";
        assertEquals(expectedTitle, volumeInfo.getTitle());
    }
//
//    @Test
//    void searchBooks() {
//    https://www.googleapis.com/books/v1/volumes?q=intitle:the+fifth+element
//        GoogleBooksAPI googleBooksAPI = new GoogleBooksAPI();
//        String queryParam = "intitle";
//        String queryTerm = "the fifth element";
//        queryTerm = queryTerm.replaceAll("\\s", "+");
//        List<VolumeInfo> searchResults = googleBooksAPI.searchBooks(queryParam, queryTerm);
//        VolumeInfo topResult = searchResults.get(0);
//        String expectedTitle = "The Fifth Element";
//        assertEquals(expectedTitle, topResult.getTitle());
//    }
}