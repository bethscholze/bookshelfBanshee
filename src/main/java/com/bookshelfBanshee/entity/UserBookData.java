package com.bookshelfBanshee.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "UserBookData")
@Table(name = "user_book_data")
public class UserBookData {
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
    private User user;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataLabel() {
        return dataLabel;
    }

    public void setDataLabel(String dataLabel) {
        this.dataLabel = dataLabel;
    }

    public String getDataValue() {
        return dataValue;
    }

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
