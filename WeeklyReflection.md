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


### hibernate problems
user_book to user_book_data
change many to many to one to manys on both sides
add extra instance variables for data
look into hibernate filters for filtering the results for user_books
-would want only one book even if lots of data for each book, since query would grab all data.
https://docs.jboss.org/hibernate/core/3.6/reference/en-US/html/filters.html
@Entity
@FilterDef(name="minLength", parameters=@ParamDef( name="minLength", type="integer" ) )
@Filters( {
    @Filter(name="betweenLength", condition=":minLength <= length and :maxLength >= length"),
    @Filter(name="minLength", condition=":minLength <= length")
} )
public class Forest { ... }
the relationship between data and book might be reversed too ie bookdata would map book?


Link to rest client if not in the same class for tests...
https://www.ibm.com/mysupport/s/question/0D50z00005q4DZ9CAM/using-javaxwsrsclientclientbuilder-in-junit?language=en_US

resetting mysql password
http://www.ihp.sinica.edu.tw/dashboard/docs/reset-mysql-password.html

json links
https://stackoverflow.com/questions/41989906/jackson-referencing-an-object-as-a-property
https://stackoverflow.com/questions/3325387/infinite-recursion-with-jackson-json-and-hibernate-jpa-issue
https://stackoverflow.com/questions/48117059/could-not-write-json-failed-to-lazily-initialize-a-collection-of-role/48152153


////////////////////////////////////////////////////////////////
In my project I came across the same problem as yours. The problem is that by the time of reading the data "one to many" the session has already been closed. To get all the data, you need to explicitly initialize or use the transaction. I used an explicit initialization. You need to add a line in the DAO:

Hibernate.initialize(supplier.getIngredients());

After that, Hibernate will load all the data from the database. To avoid generating an exception when serializing to JSON, I add the @JsonIgnore annotation in the one-to-many model field.

Here is an example of my code:

1.Model

@OneToMany(mappedBy = "commandByEv", fetch = FetchType.LAZY)
@JsonIgnore
private Set<Evaluation> evaluations;

2. DAO

public Command getCommand(long id) {
Session session = sessionFactory.getCurrentSession();
Evaluation evaluation = session.get(Evaluation.class, id);
Hibernate.initialize(evaluation.getCommand());
return evaluation.getCommand();
}

//////////////////////////////////////////////////////////////////////////////////////////////