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
//
//    String jsonResponseSearch = {
//            "kind": "books#volumes",
//            "totalItems": 460,
//            "items": [
//    {
//        "kind": "books#volume",
//            "id": "eQoBtAEACAAJ",
//            "etag": "Y1BpQ55TGgY",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/eQoBtAEACAAJ",
//            "volumeInfo": {
//        "title": "The Fifth Element",
//                "authors": [
//        "Terry Bisson"
//    ],
//        "publishedDate": "1997",
//                "description": "Exciting film tie-in to the huge new $90 million sf blockbuster film from Luc Besson (director of NIKITA and THE BIG BLUE) starring Bruce Willis and Gary Oldman.",
//                "industryIdentifiers": [
//        {
//            "type": "ISBN_10",
//                "identifier": "0006483461"
//        },
//        {
//            "type": "ISBN_13",
//                "identifier": "9780006483465"
//        }
//    ],
//        "readingModes": {
//            "text": false,
//                    "image": false
//        },
//        "pageCount": 250,
//                "printType": "BOOK",
//                "categories": [
//        "Fiction"
//    ],
//        "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": false,
//                "contentVersion": "preview-1.0.0",
//                "panelizationSummary": {
//            "containsEpubBubbles": false,
//                    "containsImageBubbles": false
//        },
//        "imageLinks": {
//            "smallThumbnail": "http://books.google.com/books/content?id=eQoBtAEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
//                    "thumbnail": "http://books.google.com/books/content?id=eQoBtAEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=eQoBtAEACAAJ&dq=intitle:the+fifth+element&hl=&cd=1&source=gbs_api",
//                "infoLink": "http://books.google.com/books?id=eQoBtAEACAAJ&dq=intitle:the+fifth+element&hl=&source=gbs_api",
//                "canonicalVolumeLink": "https://books.google.com/books/about/The_Fifth_Element.html?hl=&id=eQoBtAEACAAJ"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "NOT_FOR_SALE",
//                "isEbook": false
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "NO_PAGES",
//                "embeddable": false,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": false
//        },
//        "pdf": {
//            "isAvailable": false
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=eQoBtAEACAAJ&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "NONE",
//                "quoteSharingAllowed": false
//    },
//        "searchInfo": {
//        "textSnippet": "Exciting film tie-in to the huge new $90 million sf blockbuster film from Luc Besson (director of NIKITA and THE BIG BLUE) starring Bruce Willis and Gary Oldman."
//    }
//    },
//    {
//        "kind": "books#volume",
//            "id": "96tLCwAAQBAJ",
//            "etag": "B2QKuyCh5gM",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/96tLCwAAQBAJ",
//            "volumeInfo": {
//        "title": "The Fifth Element",
//                "subtitle": "Social Justice Pedagogy through Spoken Word Poetry",
//                "authors": [
//        "Crystal Leigh Endsley"
//    ],
//        "publisher": "SUNY Press",
//                "publishedDate": "2015-12-28",
//                "description": "Explores spoken word poetry as a tool for social justice, critical feminist pedagogy, and new ways of teaching. The writing and performance of spoken word poetry can create moments of productive critical engagement. In The Fifth Element, Crystal Leigh Endsley charts her experience of working with a dynamic and diverse group of college students, who are also emerging artists, to explore the connection between spoken word and social responsibility. She considers how themes of activism, identity, and love intersect with the lived experiences of these students and how they use spoken word to negotiate resistance and to navigate through life. Endsley also examines the local and transnational communities where performances took place to shed light on concepts of social responsibility and knowledge production.",
//                "industryIdentifiers": [
//        {
//            "type": "ISBN_13",
//                "identifier": "9781438459851"
//        },
//        {
//            "type": "ISBN_10",
//                "identifier": "1438459858"
//        }
//    ],
//        "readingModes": {
//            "text": false,
//                    "image": true
//        },
//        "pageCount": 184,
//                "printType": "BOOK",
//                "categories": [
//        "Education"
//    ],
//        "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": false,
//                "contentVersion": "preview-1.0.0",
//                "imageLinks": {
//            "smallThumbnail": "http://books.google.com/books/content?id=96tLCwAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
//                    "thumbnail": "http://books.google.com/books/content?id=96tLCwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=96tLCwAAQBAJ&pg=PR17&dq=intitle:the+fifth+element&hl=&cd=2&source=gbs_api",
//                "infoLink": "http://books.google.com/books?id=96tLCwAAQBAJ&dq=intitle:the+fifth+element&hl=&source=gbs_api",
//                "canonicalVolumeLink": "https://books.google.com/books/about/The_Fifth_Element.html?hl=&id=96tLCwAAQBAJ"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "NOT_FOR_SALE",
//                "isEbook": false
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "PARTIAL",
//                "embeddable": true,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": false
//        },
//        "pdf": {
//            "isAvailable": false
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=96tLCwAAQBAJ&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "SAMPLE",
//                "quoteSharingAllowed": false
//    },
//        "searchInfo": {
//        "textSnippet": "The \u003cb\u003eFifth Element\u003c/b\u003e The title of this text is reference and tribute to several cultural \u003cbr\u003e\nproducts that contribute to the performance of spoken word poetry and the \u003cbr\u003e\ncommunity served by socially responsible art. The rowdy “cousin” of spoken word \u003cbr\u003e\npoetry&nbsp;..."
//    }
//    },
//    {
//        "kind": "books#volume",
//            "id": "I53UDAAAQBAJ",
//            "etag": "QPgZHEij7PI",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/I53UDAAAQBAJ",
//            "volumeInfo": {
//        "title": "The Fifth Element",
//                "subtitle": "A Novel",
//                "authors": [
//        "Jorgen Brekke"
//    ],
//        "publisher": "Minotaur Books",
//                "publishedDate": "2017-02-28",
//                "description": "Police Inspector Odd Singsaker has been captured, imprisoned on an island off the Northern coast of Norway. He wakes to find himself holding a shotgun. Next to him is a corpse. But what events led him to this point? And how did he get here? A few weeks earlier, Felicia, his wife, disappeared. Though he didn’t know it, she was trying to find her way back to Odd to reconcile, but then she vanished into a snowstorm. Possibly involved is a corrupt, coldblooded cop from Oslo, a devious college student who’s stolen a great deal of cocaine from drug dealers, and a hit man hired by the drug dealers who have been robbed. All of these lives intersect with Odd’s as he searches for Felicia. The Fifth Element is ultimately the story of what happened to Felicia Stone. Within that journey, brutal crimes are uncovered, tenacious love shines through, and chilling characters with nothing to lose will stop at nothing to get what they want. Jorgen Brekke once again delivers a chilling thriller that readers will tear through to unravel what happened-and why.",
//                "industryIdentifiers": [
//        {
//            "type": "ISBN_13",
//                "identifier": "9781466885417"
//        },
//        {
//            "type": "ISBN_10",
//                "identifier": "1466885416"
//        }
//    ],
//        "readingModes": {
//            "text": true,
//                    "image": false
//        },
//        "pageCount": 336,
//                "printType": "BOOK",
//                "categories": [
//        "Fiction"
//    ],
//        "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": false,
//                "contentVersion": "1.2.2.0.preview.2",
//                "panelizationSummary": {
//            "containsEpubBubbles": false,
//                    "containsImageBubbles": false
//        },
//        "imageLinks": {
//            "smallThumbnail": "http://books.google.com/books/content?id=I53UDAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
//                    "thumbnail": "http://books.google.com/books/content?id=I53UDAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=I53UDAAAQBAJ&pg=PA183&dq=intitle:the+fifth+element&hl=&cd=3&source=gbs_api",
//                "infoLink": "https://play.google.com/store/books/details?id=I53UDAAAQBAJ&source=gbs_api",
//                "canonicalVolumeLink": "https://play.google.com/store/books/details?id=I53UDAAAQBAJ"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "FOR_SALE",
//                "isEbook": true,
//                "listPrice": {
//            "amount": 9.99,
//                    "currencyCode": "USD"
//        },
//        "retailPrice": {
//            "amount": 9.99,
//                    "currencyCode": "USD"
//        },
//        "buyLink": "https://play.google.com/store/books/details?id=I53UDAAAQBAJ&rdid=book-I53UDAAAQBAJ&rdot=1&source=gbs_api",
//                "offers": [
//        {
//            "finskyOfferType": 1,
//                "listPrice": {
//            "amountInMicros": 9990000.0,
//                    "currencyCode": "USD"
//        },
//            "retailPrice": {
//            "amountInMicros": 9990000.0,
//                    "currencyCode": "USD"
//        },
//            "giftable": true
//        }
//    ]
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "PARTIAL",
//                "embeddable": true,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": true,
//                    "acsTokenLink": "http://books.google.com/books/download/The_Fifth_Element-sample-epub.acsm?id=I53UDAAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
//        },
//        "pdf": {
//            "isAvailable": false
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=I53UDAAAQBAJ&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "SAMPLE",
//                "quoteSharingAllowed": false
//    },
//        "searchInfo": {
//        "textSnippet": "It&#39;s the \u003cb\u003efifth element\u003c/b\u003e.” “What are you getting at?” “I like to warm up. Don&#39;t you?” \u003cbr\u003e\nNow Gregersen intervened. “If this isn&#39;t relevant to the case, then I suggest we \u003cbr\u003e\nmove on to more factual issues.” “This is a complicated case,” said Melhus calmly\u003cbr\u003e\n."
//    }
//    },
//    {
//        "kind": "books#volume",
//            "id": "Jc6UAAAAQBAJ",
//            "etag": "MnTixqNKsqo",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/Jc6UAAAAQBAJ",
//            "volumeInfo": {
//        "title": "PEMF - The Fifth Element of Health",
//                "subtitle": "Learn Why Pulsed Electromagnetic Field (PEMF) Therapy Supercharges Your Health Like Nothing Else!",
//                "authors": [
//        "Bryant A. Meyers"
//    ],
//        "publisher": "BalboaPress",
//                "publishedDate": "2013-08-19",
//                "description": "You probably know that food, water, sunlight, and oxygen are required for life, but there is a fifth element of health that is equally vital and often overlooked: The Earth’s magnetic field and its corresponding PEMFs (pulsed electromagnetic fields). The two main components of Earth’s PEMFs, the Schumann and Geomagnetic frequencies, are so essential that NASA and the Russian space program equip their spacecrafts with devices that replicate these frequencies. These frequencies are absolutely necessary for the human body’s circadian rhythms, energy production, and even keeping the body free from pain. But there is a big problem on planet earth right now, rather, a twofold problem, as to why we are no longer getting these life-nurturing energies of the earth. In this book we’ll explore the current problem and how the new science of PEMF therapy (a branch of energy medicine), based on modern quantum field theory, is the solution to this problem, with the many benefits listed below: • eliminate pain and inflammation naturally • get deep, rejuvenating sleep • increase your energy and vitality • feel younger, stronger, and more flexible • keep your bones strong and healthy • help your body with healing and regeneration • improve circulation and heart health • plus many more benefits",
//                "industryIdentifiers": [
//        {
//            "type": "ISBN_13",
//                "identifier": "9781452579238"
//        },
//        {
//            "type": "ISBN_10",
//                "identifier": "1452579237"
//        }
//    ],
//        "readingModes": {
//            "text": true,
//                    "image": true
//        },
//        "pageCount": 234,
//                "printType": "BOOK",
//                "categories": [
//        "Health & Fitness"
//    ],
//        "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": true,
//                "contentVersion": "3.7.6.0.preview.3",
//                "panelizationSummary": {
//            "containsEpubBubbles": false,
//                    "containsImageBubbles": false
//        },
//        "imageLinks": {
//            "smallThumbnail": "http://books.google.com/books/content?id=Jc6UAAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
//                    "thumbnail": "http://books.google.com/books/content?id=Jc6UAAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=Jc6UAAAAQBAJ&pg=PA18&dq=intitle:the+fifth+element&hl=&cd=4&source=gbs_api",
//                "infoLink": "https://play.google.com/store/books/details?id=Jc6UAAAAQBAJ&source=gbs_api",
//                "canonicalVolumeLink": "https://play.google.com/store/books/details?id=Jc6UAAAAQBAJ"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "FOR_SALE",
//                "isEbook": true,
//                "listPrice": {
//            "amount": 3.99,
//                    "currencyCode": "USD"
//        },
//        "retailPrice": {
//            "amount": 3.99,
//                    "currencyCode": "USD"
//        },
//        "buyLink": "https://play.google.com/store/books/details?id=Jc6UAAAAQBAJ&rdid=book-Jc6UAAAAQBAJ&rdot=1&source=gbs_api",
//                "offers": [
//        {
//            "finskyOfferType": 1,
//                "listPrice": {
//            "amountInMicros": 3990000.0,
//                    "currencyCode": "USD"
//        },
//            "retailPrice": {
//            "amountInMicros": 3990000.0,
//                    "currencyCode": "USD"
//        },
//            "giftable": true
//        }
//    ]
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "PARTIAL",
//                "embeddable": true,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": true,
//                    "acsTokenLink": "http://books.google.com/books/download/PEMF_The_Fifth_Element_of_Health-sample-epub.acsm?id=Jc6UAAAAQBAJ&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
//        },
//        "pdf": {
//            "isAvailable": true,
//                    "acsTokenLink": "http://books.google.com/books/download/PEMF_The_Fifth_Element_of_Health-sample-pdf.acsm?id=Jc6UAAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=Jc6UAAAAQBAJ&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "SAMPLE",
//                "quoteSharingAllowed": false
//    },
//        "searchInfo": {
//        "textSnippet": "I also like to do whole body vibration exercise for 10 minutes a day. Wait ..., we \u003cbr\u003e\nleft out an important and essential \u003cb\u003eelement\u003c/b\u003e to the physical health and well-being \u003cbr\u003e\nof our human bodies ..., drumroll please—earth PEMF—The \u003cb\u003efifth element\u003c/b\u003e of \u003cbr\u003e\nhealth!"
//    }
//    },
//    {
//        "kind": "books#volume",
//            "id": "iGW_BAAAQBAJ",
//            "etag": "Q/jnS+5Auf4",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/iGW_BAAAQBAJ",
//            "volumeInfo": {
//        "title": "Pointless Conversations: The Fifth Element",
//                "authors": [
//        "Scott Tierney"
//    ],
//        "publisher": "Andrews UK Limited",
//                "publishedDate": "2011-05-26",
//                "description": "Pointless conversations: a selection of daft, ridiculous and utterly pointless meanderings from the mind of Scott Tierney. If you’ve ever wanted to know the answers to why Superman is a coward; why Spiderman should technically be deformed; and if Superdog caused the death of Krypton, then these bite-sized comics will reveal all. The discussions may be insane, and most of what is said is rambling, but despite this, you may find yourself agreeing with most of what is said. It’s a fair point: where does Spiderman store all that web?",
//                "industryIdentifiers": [
//        {
//            "type": "ISBN_13",
//                "identifier": "9781849894135"
//        },
//        {
//            "type": "ISBN_10",
//                "identifier": "1849894132"
//        }
//    ],
//        "readingModes": {
//            "text": false,
//                    "image": true
//        },
//        "pageCount": 88,
//                "printType": "BOOK",
//                "categories": [
//        "Humor"
//    ],
//        "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": false,
//                "contentVersion": "0.1.1.0.preview.1",
//                "panelizationSummary": {
//            "containsEpubBubbles": false,
//                    "containsImageBubbles": false
//        },
//        "imageLinks": {
//            "smallThumbnail": "http://books.google.com/books/content?id=iGW_BAAAQBAJ&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
//                    "thumbnail": "http://books.google.com/books/content?id=iGW_BAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=iGW_BAAAQBAJ&pg=PT2&dq=intitle:the+fifth+element&hl=&cd=5&source=gbs_api",
//                "infoLink": "https://play.google.com/store/books/details?id=iGW_BAAAQBAJ&source=gbs_api",
//                "canonicalVolumeLink": "https://play.google.com/store/books/details?id=iGW_BAAAQBAJ"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "FOR_SALE",
//                "isEbook": true,
//                "listPrice": {
//            "amount": 2.99,
//                    "currencyCode": "USD"
//        },
//        "retailPrice": {
//            "amount": 2.99,
//                    "currencyCode": "USD"
//        },
//        "buyLink": "https://play.google.com/store/books/details?id=iGW_BAAAQBAJ&rdid=book-iGW_BAAAQBAJ&rdot=1&source=gbs_api",
//                "offers": [
//        {
//            "finskyOfferType": 1,
//                "listPrice": {
//            "amountInMicros": 2990000.0,
//                    "currencyCode": "USD"
//        },
//            "retailPrice": {
//            "amountInMicros": 2990000.0,
//                    "currencyCode": "USD"
//        },
//            "giftable": true
//        }
//    ]
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "PARTIAL",
//                "embeddable": true,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": false
//        },
//        "pdf": {
//            "isAvailable": true,
//                    "acsTokenLink": "http://books.google.com/books/download/Pointless_Conversations_The_Fifth_Elemen-sample-pdf.acsm?id=iGW_BAAAQBAJ&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=iGW_BAAAQBAJ&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "SAMPLE",
//                "quoteSharingAllowed": false
//    },
//        "searchInfo": {
//        "textSnippet": "Scott Tierney. Title Page Pointless Conversations THE \u003cb\u003eFIFTH ELEMENT\u003c/b\u003e By Scott \u003cbr\u003e\nTierney Publisher Information Pointless Conversations: The \u003cb\u003eFifth Element\u003c/b\u003e \u003cbr\u003e\npublished in 2011 Front Matter: Title Page."
//    }
//    },
//    {
//        "kind": "books#volume",
//            "id": "a75ZNQAACAAJ",
//            "etag": "9ln3sT+5gI8",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/a75ZNQAACAAJ",
//            "volumeInfo": {
//        "title": "The Story of The Fifth Element",
//                "subtitle": "The Adventure and Discovery of a Film",
//                "authors": [
//        "Luc Besson"
//    ],
//        "publishedDate": "1997",
//                "industryIdentifiers": [
//        {
//            "type": "ISBN_10",
//                "identifier": "1852868635"
//        },
//        {
//            "type": "ISBN_13",
//                "identifier": "9781852868635"
//        }
//    ],
//        "readingModes": {
//            "text": false,
//                    "image": false
//        },
//        "pageCount": 240,
//                "printType": "BOOK",
//                "categories": [
//        "Fifth element (Motion picture)"
//    ],
//        "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": false,
//                "contentVersion": "preview-1.0.0",
//                "imageLinks": {
//            "smallThumbnail": "http://books.google.com/books/content?id=a75ZNQAACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
//                    "thumbnail": "http://books.google.com/books/content?id=a75ZNQAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=a75ZNQAACAAJ&dq=intitle:the+fifth+element&hl=&cd=6&source=gbs_api",
//                "infoLink": "http://books.google.com/books?id=a75ZNQAACAAJ&dq=intitle:the+fifth+element&hl=&source=gbs_api",
//                "canonicalVolumeLink": "https://books.google.com/books/about/The_Story_of_The_Fifth_Element.html?hl=&id=a75ZNQAACAAJ"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "NOT_FOR_SALE",
//                "isEbook": false
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "NO_PAGES",
//                "embeddable": false,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": false
//        },
//        "pdf": {
//            "isAvailable": false
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=a75ZNQAACAAJ&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "NONE",
//                "quoteSharingAllowed": false
//    }
//    },
//    {
//        "kind": "books#volume",
//            "id": "NsaomAEACAAJ",
//            "etag": "aMAVLlqaOVw",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/NsaomAEACAAJ",
//            "volumeInfo": {
//        "title": "Toby Smith and the Fifth Element",
//                "authors": [
//        "Jeff Dale"
//    ],
//        "publishedDate": "2006-09-01",
//                "description": "When 13 year-old schoolboy Toby Smith finds himself in another world where he is asked to save the Universe from destruction, he sets out in search of four life-giving elements that are needed to repair the gravity machine, which is an ancient device that keeps the celestial bodies in orbit and creates secret doors between distant worlds. As the Stinger Queen's deadly horde of drones search for him, can he find the courage to overcome the terrible trials that lay before him? Or will the sadistic Wasp Queen suck him dry and plunge the Universe into slavery? Is this baby-faced warrior just another kid on the block who will be cast aside by his deadly enemies? Or is he the voice of reason and the hero that we all have inside us? This story teaches children about the capabilities of the human race to overcome any obstacles and believe in ourselves to become more than we ever imagined.",
//                "industryIdentifiers": [
//        {
//            "type": "ISBN_10",
//                "identifier": "1425954871"
//        },
//        {
//            "type": "ISBN_13",
//                "identifier": "9781425954871"
//        }
//    ],
//        "readingModes": {
//            "text": false,
//                    "image": false
//        },
//        "pageCount": 248,
//                "printType": "BOOK",
//                "categories": [
//        "Fiction"
//    ],
//        "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": false,
//                "contentVersion": "preview-1.0.0",
//                "imageLinks": {
//            "smallThumbnail": "http://books.google.com/books/content?id=NsaomAEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
//                    "thumbnail": "http://books.google.com/books/content?id=NsaomAEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=NsaomAEACAAJ&dq=intitle:the+fifth+element&hl=&cd=7&source=gbs_api",
//                "infoLink": "http://books.google.com/books?id=NsaomAEACAAJ&dq=intitle:the+fifth+element&hl=&source=gbs_api",
//                "canonicalVolumeLink": "https://books.google.com/books/about/Toby_Smith_and_the_Fifth_Element.html?hl=&id=NsaomAEACAAJ"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "NOT_FOR_SALE",
//                "isEbook": false
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "NO_PAGES",
//                "embeddable": false,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": false
//        },
//        "pdf": {
//            "isAvailable": false
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=NsaomAEACAAJ&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "NONE",
//                "quoteSharingAllowed": false
//    },
//        "searchInfo": {
//        "textSnippet": "Or is he the voice of reason and the hero that we all have inside us? This story teaches children about the capabilities of the human race to overcome any obstacles and believe in ourselves to become more than we ever imagined."
//    }
//    },
//    {
//        "kind": "books#volume",
//            "id": "2lAZzQEACAAJ",
//            "etag": "kbFNL7iPoTQ",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/2lAZzQEACAAJ",
//            "volumeInfo": {
//        "title": "The Fifth Element",
//                "subtitle": "A Collection of Poems",
//                "authors": [
//        "Manju Seth"
//    ],
//        "publishedDate": "2001",
//                "industryIdentifiers": [
//        {
//            "type": "OTHER",
//                "identifier": "OCLC:470640919"
//        }
//    ],
//        "readingModes": {
//            "text": false,
//                    "image": false
//        },
//        "pageCount": 64,
//                "printType": "BOOK",
//                "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": false,
//                "contentVersion": "preview-1.0.0",
//                "panelizationSummary": {
//            "containsEpubBubbles": false,
//                    "containsImageBubbles": false
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=2lAZzQEACAAJ&dq=intitle:the+fifth+element&hl=&cd=8&source=gbs_api",
//                "infoLink": "http://books.google.com/books?id=2lAZzQEACAAJ&dq=intitle:the+fifth+element&hl=&source=gbs_api",
//                "canonicalVolumeLink": "https://books.google.com/books/about/The_Fifth_Element.html?hl=&id=2lAZzQEACAAJ"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "NOT_FOR_SALE",
//                "isEbook": false
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "NO_PAGES",
//                "embeddable": false,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": false
//        },
//        "pdf": {
//            "isAvailable": false
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=2lAZzQEACAAJ&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "NONE",
//                "quoteSharingAllowed": false
//    }
//    },
//    {
//        "kind": "books#volume",
//            "id": "rNuOPQAACAAJ",
//            "etag": "k26O0qYxv4M",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/rNuOPQAACAAJ",
//            "volumeInfo": {
//        "title": "The Fifth Tarot",
//                "subtitle": "Restoring the Fifth Element : Fire, Water, Air, Earth ... and Ether",
//                "authors": [
//        "Martien Bakens",
//                "Teressena Bakens"
//    ],
//        "publisher": "Blue Dolphin Pub",
//                "publishedDate": "2008",
//                "description": "As we enter the Aquarian Age of Peace, new tarot imagery and symbols are called for that reinforce our oneness with the natural world. The Fifth Tarot introduces images of nature to represent the elements for each of the suits—fire, shells, feathers, stones, and lotuses.Boxed set: 352 pg Book and 92 full-color cards",
//                "industryIdentifiers": [
//        {
//            "type": "ISBN_10",
//                "identifier": "1577332210"
//        },
//        {
//            "type": "ISBN_13",
//                "identifier": "9781577332213"
//        }
//    ],
//        "readingModes": {
//            "text": false,
//                    "image": false
//        },
//        "pageCount": 336,
//                "printType": "BOOK",
//                "categories": [
//        "Body, Mind & Spirit"
//    ],
//        "averageRating": 5.0,
//                "ratingsCount": 1,
//                "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": false,
//                "contentVersion": "preview-1.0.0",
//                "imageLinks": {
//            "smallThumbnail": "http://books.google.com/books/content?id=rNuOPQAACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
//                    "thumbnail": "http://books.google.com/books/content?id=rNuOPQAACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=rNuOPQAACAAJ&dq=intitle:the+fifth+element&hl=&cd=9&source=gbs_api",
//                "infoLink": "http://books.google.com/books?id=rNuOPQAACAAJ&dq=intitle:the+fifth+element&hl=&source=gbs_api",
//                "canonicalVolumeLink": "https://books.google.com/books/about/The_Fifth_Tarot.html?hl=&id=rNuOPQAACAAJ"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "NOT_FOR_SALE",
//                "isEbook": false
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "NO_PAGES",
//                "embeddable": false,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": false
//        },
//        "pdf": {
//            "isAvailable": false
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=rNuOPQAACAAJ&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "NONE",
//                "quoteSharingAllowed": false
//    },
//        "searchInfo": {
//        "textSnippet": "The Fifth Tarot introduces images of nature to represent the elements for each of the suits—fire, shells, feathers, stones, and lotuses.Boxed set: 352 pg Book and 92 full-color cards"
//    }
//    },
//    {
//        "kind": "books#volume",
//            "id": "ofqfmenNlGsC",
//            "etag": "t45EatAdAyc",
//            "selfLink": "https://www.googleapis.com/books/v1/volumes/ofqfmenNlGsC",
//            "volumeInfo": {
//        "title": "Quinta Essentia - The Five Elements",
//                "authors": [
//        "Morag Campbell"
//    ],
//        "publisher": "MWI Publishing",
//                "publishedDate": "2003",
//                "description": "The Quinta Essentia is the elusive fifth element which creates the stage for the more familiar astrological elements of Air, Fire, Water and Earth to be expressed. To discover and truly understand our essential self we must explore the unique combination of all the elements as they play through our life.You have all heard of \"space cadets\", \"air heads\", \"hot heads\", \"wet blankets\", \"stick in the muds\" and the like, but do you know how these terms came about? This book explains how our personalities, modes of communication, even our health problems are related to the balance of the Five Elements which are the building blocks of life. Getting to know these elements and how they manifest in our lives, enriches our understading of ourselves and others, improves our relationships and gives direction and purpose to our life.",
//                "industryIdentifiers": [
//        {
//            "type": "ISBN_13",
//                "identifier": "9780954445003"
//        },
//        {
//            "type": "ISBN_10",
//                "identifier": "0954445007"
//        }
//    ],
//        "readingModes": {
//            "text": true,
//                    "image": true
//        },
//        "pageCount": 132,
//                "printType": "BOOK",
//                "categories": [
//        "Body, Mind & Spirit"
//    ],
//        "maturityRating": "NOT_MATURE",
//                "allowAnonLogging": false,
//                "contentVersion": "0.0.1.0.preview.3",
//                "panelizationSummary": {
//            "containsEpubBubbles": false,
//                    "containsImageBubbles": false
//        },
//        "imageLinks": {
//            "smallThumbnail": "http://books.google.com/books/content?id=ofqfmenNlGsC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
//                    "thumbnail": "http://books.google.com/books/content?id=ofqfmenNlGsC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
//        },
//        "language": "en",
//                "previewLink": "http://books.google.com/books?id=ofqfmenNlGsC&pg=PA106&dq=intitle:the+fifth+element&hl=&cd=10&source=gbs_api",
//                "infoLink": "http://books.google.com/books?id=ofqfmenNlGsC&dq=intitle:the+fifth+element&hl=&source=gbs_api",
//                "canonicalVolumeLink": "https://books.google.com/books/about/Quinta_Essentia_The_Five_Elements.html?hl=&id=ofqfmenNlGsC"
//    },
//        "saleInfo": {
//        "country": "US",
//                "saleability": "NOT_FOR_SALE",
//                "isEbook": false
//    },
//        "accessInfo": {
//        "country": "US",
//                "viewability": "PARTIAL",
//                "embeddable": true,
//                "publicDomain": false,
//                "textToSpeechPermission": "ALLOWED",
//                "epub": {
//            "isAvailable": true,
//                    "acsTokenLink": "http://books.google.com/books/download/Quinta_Essentia_The_Five_Elements-sample-epub.acsm?id=ofqfmenNlGsC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
//        },
//        "pdf": {
//            "isAvailable": false
//        },
//        "webReaderLink": "http://play.google.com/books/reader?id=ofqfmenNlGsC&hl=&printsec=frontcover&source=gbs_api",
//                "accessViewStatus": "SAMPLE",
//                "quoteSharingAllowed": false
//    },
//        "searchInfo": {
//        "textSnippet": "THE. ELUSIVE. \u003cb\u003eFIFTH\u003c/b\u003e. \u003cb\u003eELEMENT\u003c/b\u003e. ETHER. And so at last to the Quinta Essentia, \u003cbr\u003e\nthe most elusive, most essential, purest and most perfect \u003cb\u003eelement\u003c/b\u003e which is latent \u003cbr\u003e\nin all things. Because it is not as tangible as the other \u003cb\u003eelements\u003c/b\u003e it is often ignored\u003cbr\u003e\n&nbsp;..."
//    }
//    }
// ]
//}
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

    @Test
    void searchBooks() {
//    https://www.googleapis.com/books/v1/volumes?q=intitle:the+fifth+element
        GoogleBooksAPI googleBooksAPI = new GoogleBooksAPI();
        String queryParam = "intitle";
        String queryTerm = "the fifth element";
        queryTerm = queryTerm.replaceAll("\\s", "+");
        List<VolumeInfo> searchResults = googleBooksAPI.searchBooks(queryParam, queryTerm);
        VolumeInfo topResult = searchResults.get(0);
        String expectedTitle = "The Fifth Element";
        assertEquals(expectedTitle, topResult.getTitle());
    }
}