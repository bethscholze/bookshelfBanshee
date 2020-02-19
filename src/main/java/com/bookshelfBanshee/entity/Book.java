package com.bookshelfBanshee.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Book")
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    //@Column
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

    public Book() {
    }

    public Book(int isbn10, int isbn13, String title, String author, User user) {
        this.user = user;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.title = title;
        this.author = author;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(int isbn10) {
        this.isbn10 = isbn10;
    }

    public int getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(int isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

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
