package com.ftts.model;

import javax.persistence.*;

@Table
@Entity
public class Racer {

    @Id
    @OneToMany
    private int id;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String firstName;
    @Column
    private String lastname;

    public Racer(int id, String email, String password, String firstName, String lastname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
