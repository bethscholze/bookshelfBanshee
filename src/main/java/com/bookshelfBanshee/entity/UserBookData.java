package com.bookshelfBanshee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type User book data.
 */
@Entity(name = "UserBookData")
@Table(name = "user_book_data")
public class UserBookData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "data_label")
    private String dataLabel;

    @Column(name = "data_value")
    private String dataValue;

    @ManyToOne
    @JoinColumn(name = "book_id", foreignKey = @ForeignKey(name = "user_book_data_book_id_fk"))
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_book_data_user_id_fk"))
//    @JsonBackReference
    private User user;

    public UserBookData() {
    }

    public UserBookData(User user, Book book, String dataLabel, String dataValue) {
        this.dataLabel = dataLabel;
        this.dataValue = dataValue;
        this.book = book;
        this.user = user;
    }

    /**
     * Gets book.
     *
     * @return the book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets book.
     *
     * @param book the book
     */
    public void setBook(Book book) {
        this.book = book;
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
     * Gets data label.
     *
     * @return the data label
     */
    public String getDataLabel() {
        return dataLabel;
    }

    /**
     * Sets data label.
     *
     * @param dataLabel the data label
     */
    public void setDataLabel(String dataLabel) {
        this.dataLabel = dataLabel;
    }

    /**
     * Gets data value.
     *
     * @return the data value
     */
    public String getDataValue() {
        return dataValue;
    }

    /**
     * Sets data value.
     *
     * @param dataValue the data value
     */
    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserBookData that = (UserBookData) o;
        return id == that.id &&
                Objects.equals(dataLabel, that.dataLabel) &&
                Objects.equals(dataValue, that.dataValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataLabel, dataValue);
    }

    @Override
    public String toString() {
        return "UserBookData{" +
                "id=" + id +
                ", dataLabel='" + dataLabel + '\'' +
                ", dataValue='" + dataValue + '\'' +
                '}';
    }
}
