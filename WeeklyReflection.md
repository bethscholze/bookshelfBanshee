# Weekly notes/sources

- how do i want to store book data
- What does the book object/dao look like if I am not storing data?
- I still need variables for the data in the entity, I think. It just wont get pulled from the database
- I do need to make a table for extra inserted data, and that will have to be loaded for each book when it is needed. probably a getAllData in books that pulls data from the api and data table
- will need a viewBookDetails that calls the getAllData() function so all user input and api data on a book can be seen. 
- https://developers.google.com/books/docs/v1/using#st_params  --has isbn, maxResults

- I know caches are hard, could I query on start up and store data in session for the user?
- maybe limit to certain books, how should I do this, maybe have active reading lists and preferentially load that data?
- oooo maybe temporary mysql storage, ie query at start then drop data so I am not permanently storing the data.....
