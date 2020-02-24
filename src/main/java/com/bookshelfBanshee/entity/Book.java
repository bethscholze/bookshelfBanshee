package com.bookshelfBanshee.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Book.
 */
@Entity(name = "Book")
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "isbn_10")
    private String isbn10;

    @Column(name = "isbn_13")
    private String isbn13;

    //double check that I don't have to specify since the names are the same as the column
    @Column(name = "title")
    private String title;

    // TODO fix this, there can be more than one author, needs to be an array....figure out how to store in table
    @Column(name = "author")
    private String author;

    @ManyToOne
    private User user;

    // TODO add in data instance variables that arent stored in db: publishedDate, pages



    /**
     * Instantiates a new Book.
     */
    public Book() {
    }

    /**
     * Instantiates a new Book.
     *
     * @param isbn10 the isbn 10
     * @param isbn13 the isbn 13
     * @param title  the title
     * @param author the author
     * @param user   the user
     */
    public Book(String isbn10, String isbn13, String title, String author, User user) {
        this.user = user;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets isbn 10.
     *
     * @return the isbn 10
     */
    public String getIsbn10() {
        return isbn10;
    }

    /**
     * Sets isbn 10.
     *
     * @param isbn10 the isbn 10
     */
    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    /**
     * Gets isbn 13.
     *
     * @return the isbn 13
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     * Sets isbn 13.
     *
     * @param isbn13 the isbn 13
     */
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(isbn10, book.isbn10) &&
                Objects.equals(isbn13, book.isbn13) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn10, isbn13, title, author);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
