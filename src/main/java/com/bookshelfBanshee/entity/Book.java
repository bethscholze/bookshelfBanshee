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

    @ManyToOne //book is the child table of users so gets a one to many with a User
    private User user;

    @Column(name = "isbn_10")
    private int isbn10;

    @Column(name = "isbn_13")
    private int isbn13;

    //double check that I don't have to specify since the names are the same as the column
    @Column
    private String title;

    @Column
    private String author;

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
    public Book(int isbn10, int isbn13, String title, String author, User user) {
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
    public int getIsbn10() {
        return isbn10;
    }

    /**
     * Sets isbn 10.
     *
     * @param isbn10 the isbn 10
     */
    public void setIsbn10(int isbn10) {
        this.isbn10 = isbn10;
    }

    /**
     * Gets isbn 13.
     *
     * @return the isbn 13
     */
    public int getIsbn13() {
        return isbn13;
    }

    /**
     * Sets isbn 13.
     *
     * @param isbn13 the isbn 13
     */
    public void setIsbn13(int isbn13) {
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
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", user=" + user +
                ", isbn10=" + isbn10 +
                ", isbn13=" + isbn13 +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                isbn10 == book.isbn10 &&
                isbn13 == book.isbn13 &&
                Objects.equals(user, book.user) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, isbn10, isbn13, title, author);
    }
}
