package com.bookshelfBanshee.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Role.
 */
@Entity(name = "Role")
@Table(name = "user_role")
public class Role {
    @Column(name = "role")
    private String role;

//    @Column(name = "username")
    //private String username;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    // this sets the user, I will have to pull the username out of this ifI want to access it
    // with the one to many relationship mapping on the username, I cannot have the username
    // as an instance variable in this class
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "userrole_user_id_fk"))
    private User user;

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new Role.
     *
     * @param role     the role
     * @param id       the id
     * @param user     the user
     */
    public Role(String role, int id, User user) {
        this.role = role;
        this.id = id;
        this.user = user;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
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
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
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
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return id == role1.id &&
                Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, id);
    }
}
