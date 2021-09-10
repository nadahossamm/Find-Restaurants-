package com.example.newone.domain;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY
    )
/*    @SequenceGenerator(name = "user_sequence",
    allocationSize = 1,
            sequenceName = "user_sequence"
    )*/
    private int id;
    private String username;
    private String password;

    public User() {
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
