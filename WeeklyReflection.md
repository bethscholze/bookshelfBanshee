# Weekly notes/sources

- how do i want to store book data
- What does the book object/dao look like if I am not storing data?
- I still need variables for the data in the entity, I think. It just wont get pulled from the database
- I do need to make a table for extra inserted data, and that will have to be loaded for each book when it is needed. probably a getAllData in books that pulls data from the api and data table
- will need a viewBookDetails that calls the getAllData() function so all user input and api data on a book can be seen. 
- https://developers.google.com/books/docs/v1/using#st_params  --has isbn, maxResults
- https://developers.google.com/books/docs/v1/using#WorkingVolumes
- https://developers.google.com/books/docs/v1/using#RetrievingVolume
- Need to retrieve the specific volume with the volumeID to pull a lot of the info that I need ie
-- because of this I might need to store the volumeId instead of isbn? but what if I switch apis
industryIdentifiers[type: isbn_10, identifier: 1234567890]
publisher
publishedDate
description
pageCount
mainCategory
categories[]
averageRating
ratingsCount
imageLinks[]
language
saleInfo{country}


- I know caches are hard, could I query on start up and store data in session for the user?
- maybe limit to certain books, how should I do this, maybe have active reading lists and preferentially load that data?
- maybe temporary mysql storage, ie query at start then drop data so I am not permanently storing the data.....
- If book objects exists throughout the whole session, I could store the data in their instance vairables and it would be available throughout the session.
- I would need to be careful about putting a time limit on the session though, in case stuff gets left open.
- need to make authors an array? since books have multiple authors? 

- This is the embedded viewer api for google
- https://developers.google.com/books/docs/viewer/developers_guide
- SET UP API KEY- login to google developers with my google account...there is a create credentials

- add an AUTHOR table maybe or remove author data

- special bookDataTable table userid, dataid, column_name, data_value

- double check password length

- do I need a bookshelf controller? that everything gets routed through? like we had employee directory?

QUESTIONS for checkpoint 2

-with hibernate, I do not need to make objects for the bridging table correct?

@transient to have hibernate ignore the data that I don't want to put into the database

-make sure to implement unit testing for all my dao's as I go so I can see if I break them and am doing them correctly.


https://vladmihalcea.com/how-to-map-a-manytoone-association-using-a-non-primary-key-column/


