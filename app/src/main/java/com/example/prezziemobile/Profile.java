/*
package com.example.prezziemobile;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "profile_table",
        indices = {@Index(value="username",
                unique = true)},
        foreignKeys ={
        @ForeignKey(entity = Customer.class, parentColumns = "username", childColumns = "username", onDelete = CASCADE)})
public class Profile {

    @PrimaryKey
    private String email;

    private String username;
    private String password;

    @ColumnInfo(name="first_name")
    private String firstName;

    @ColumnInfo(name="sur_name")
    private String surName;
    private String birthday;

    @ColumnInfo(name="description_user")
    private String descriptionUser;

    @ColumnInfo(name = "logged_in")
    private boolean loggedIn;


    public Profile(String email, String username, String password, String firstName, String surName, String birthday, String descriptionUser, boolean loggedIn) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.surName = surName;
        this.birthday = birthday;
        this.descriptionUser = descriptionUser;
        this.loggedIn = loggedIn;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDescriptionUser() {
        return descriptionUser;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }
}
*/
