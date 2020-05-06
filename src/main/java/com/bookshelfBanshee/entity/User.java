package com.bookshelfBanshee.entity;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;
import java.io.Serializable;

/**
 * The type User.
 */
@Entity(name = "User")
@Table(name = "user")
public class User implements Serializable{
    //probably dont have to map these since they have the same name as the column
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    //User is the parent, it gets a set of its children(in this case) and maps one to many
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JsonManagedReference
    //this is for if I want to returna all the user data, however I will need to to a hibernate
//    initalize (in weekly reflection) because the session closes before the objects can be returned.
    @JsonIgnore
    private Set<UserBookData> userBooks = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JsonManagedReference
    @JsonIgnore
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @JsonManagedReference
    @JsonIgnore
    private List<UserList> lists = new ArrayList<>();

    /**
     * Instantiates a new User.
     */
    public User() {

    }

    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param password the password
     */
    @JsonCreator
    public User(@JsonProperty("username") String username,
                @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Gets roles.
     *
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Gets user books.
     *
     * @return the user books
     */
    public Set<UserBookData> getUserBooks() {
        return userBooks;
    }

    /**
     * Sets user books.
     *
     * @param userBooks the user books
     */
    public void setUserBooks(Set<UserBookData> userBooks) {
        this.userBooks = userBooks;
    }

    /**
     * Gets lists.
     *
     * @return the lists
     */
    public List<UserList> getLists() {
        return lists;
    }

    /**
     * Sets lists.
     *
     * @param lists the lists
     */
    public void setLists(List<UserList> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "User {" +
                "username=" + username +
                ", password=" + password +
                ", id=" + id +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, id);
    }
}

