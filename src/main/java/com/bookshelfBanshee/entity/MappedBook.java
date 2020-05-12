package com.bookshelfBanshee.entity;

import com.googlebooksapi.entity.VolumeInfo;

import java.util.Set;

/**
 * The type Mapped book.
 */
public class MappedBook {

    private int bookId;

    private Set<UserBookData> usersBookData;

    private VolumeInfo googleData;


    /**
     * Instantiates a new Mapped book.
     *
     * @param bookId     the book id
     * @param googleData the google data
     */
    public MappedBook(int bookId, VolumeInfo googleData) {
        this.bookId = bookId;
        this.googleData = googleData;
    }

    /**
     * Instantiates a new Mapped book.
     *
     * @param bookId        the book id
     * @param usersBookData the users book data
     * @param googleData    the google data
     */
    public MappedBook(int bookId, Set<UserBookData> usersBookData, VolumeInfo googleData){
        this.bookId = bookId;
        this.usersBookData = usersBookData;
        this.googleData = googleData;
    }

    /**
     * Gets book id.
     *
     * @return the book id
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Sets book id.
     *
     * @param bookId the book id
     */
    public void setBookId(int bookId) {
        bookId = bookId;
    }

    /**
     * Gets users book data.
     *
     * @return the users book data
     */
    public Set<UserBookData> getUsersBookData() {
        return usersBookData;
    }

    /**
     * Sets users book data.
     *
     * @param usersBookData the users book data
     */
    public void setUsersBookData(Set<UserBookData> usersBookData) {
        this.usersBookData = usersBookData;
    }

    /**
     * Gets google data.
     *
     * @return the google data
     */
    public VolumeInfo getGoogleData() {
        return googleData;
    }

    /**
     * Sets google data.
     *
     * @param googleData the google data
     */
    public void setGoogleData(VolumeInfo googleData) {
        this.googleData = googleData;
    }
}
