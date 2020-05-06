package com.bookshelfBanshee.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Book.
 */
@Entity(name = "Book")
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "isbn_10")
    private String isbn10;

    @Column(name = "isbn_13")
    private String isbn13;

    @ManyToMany(mappedBy = "booksOnList")
    @JsonManagedReference
    private Set<UserList> userLists = new HashSet<>();


//    @JSONproperty('author')

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
     */
    public Book(String isbn10, String isbn13) {
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
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

    public Set<UserList> getUserLists() {
        return userLists;
    }

    public void setUserLists(Set<UserList> userLists) {
        this.userLists = userLists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(isbn10, book.isbn10) &&
                Objects.equals(isbn13, book.isbn13);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn10, isbn13);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                '}';
    }
}
