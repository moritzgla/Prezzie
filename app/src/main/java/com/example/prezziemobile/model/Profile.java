package com.example.prezziemobile.model;

import java.util.Date;

public class Profile {

    private String email;
    private String username;
    private String password;
    private String firstName;
    private String surName;
    private String birthday;
    private String countryUser;
    private String descriptionUser;
    //private boolean isLoggedIn;

    /*public Profile(String email, String username, String password, String firstName, String surName, String birthday, String countryUser, String descriptionUser) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.surName = surName;
        this.birthday = birthday;
        this.countryUser = countryUser;
        this.descriptionUser = descriptionUser;
    }*/



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountryUser() {
        return countryUser;
    }

    public void setCountryUser(String countryUser) {
        this.countryUser = countryUser;
    }

    public String getDescriptionUser() {
        return descriptionUser;
    }

    public void setDescriptionUser(String descriptionUser) {
        this.descriptionUser = descriptionUser;
    }

    /*public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }*/
}
