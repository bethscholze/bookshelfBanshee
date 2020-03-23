package com.bookshelfBanshee.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type BookList.
 */
@Entity(name = "List")
@Table(name = "list")
public class BookList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "list_name")
    private String name;

    @Column(name = "list_description")
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * The Book list.
     */
    @ManyToMany(cascade = { CascadeType.PERSIST })
    @JoinTable(
            name = "user_book_list",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "list_id") }
    )
    Set<Book> bookList = new HashSet<>();

    public BookList() {
    }

    public BookList(String name, String description, User user) {
        this.name = name;
        this.description = description;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets book list.
     *
     * @return the book list
     */
    public Set<Book> getBookList() {
        return bookList;
    }

    /**
     * Sets book list.
     *
     * @param bookList the book list
     */
    public void setBookList(Set<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "BookList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookList list = (BookList) o;
        return id == list.id &&
                Objects.equals(name, list.name) &&
                Objects.equals(description, list.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
