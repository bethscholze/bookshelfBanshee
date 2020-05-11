package com.bookshelfBanshee.entity;

import com.googlebooksapi.entity.VolumeInfo;

import java.util.Set;

public class MappedBook {

    private int bookId;

    private Set<UserBookData> usersBookData;

    private VolumeInfo googleData;


    public MappedBook(int bookId, VolumeInfo googleData) {
        this.bookId = bookId;
        this.googleData = googleData;
    }

    public MappedBook(int bookId, Set<UserBookData> userBookData, VolumeInfo googleData){
        this.bookId = bookId;
        this.usersBookData = usersBookData;
        this.googleData = googleData;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        bookId = bookId;
    }

    public Set<UserBookData> getUsersBookData() {
        return usersBookData;
    }

    public void setUsersBookData(Set<UserBookData> usersBookData) {
        this.usersBookData = usersBookData;
    }

    public VolumeInfo getGoogleData() {
        return googleData;
    }

    public void setGoogleData(VolumeInfo googleData) {
        this.googleData = googleData;
    }
}
