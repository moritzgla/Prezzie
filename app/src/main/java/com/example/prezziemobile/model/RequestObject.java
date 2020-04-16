package com.example.prezziemobile.model;

public class RequestObject {

    private String firstNameRequest;
    private String surnameRequest;
    private String emailRequest;
    private String birthdayRequest;
    private String countryUserRequest;
    private String descriptionUserRequest;
    private String usernameRequest;
    private int requestId;
    private int souvenirId;
    private String amount;
    private String reward;
    private String status;
    private String countrySouvenir;
    private String souvenirName;
    private String descriptionSouvenir;
    private String price;

   /* public RequestObject(String username, int amount, float reward, String status, String countrySouvenir, String souvenirName, String descriptionSouvenir, float price) {
        this.username = username;
        this.amount = amount;
        this.reward = reward;
        this.status = status;

        this.countrySouvenir = countrySouvenir;
        this.souvenirName = souvenirName;
        this.descriptionSouvenir = descriptionSouvenir;
        this.price = price;
    }*/

    public String getFirstNameRequest() {
        return firstNameRequest;
    }

    public void setFirstNameRequest(String firstNameRequest) {
        this.firstNameRequest = firstNameRequest;
    }

    public String getSurnameRequest() {
        return surnameRequest;
    }

    public void setSurnameRequest(String surnameRequest) {
        this.surnameRequest = surnameRequest;
    }

    public String getEmailRequest() {
        return emailRequest;
    }

    public void setEmailRequest(String emailRequest) {
        this.emailRequest = emailRequest;
    }

    public String getBirthdayRequest() {
        return birthdayRequest;
    }

    public void setBirthdayRequest(String birthdayRequest) {
        this.birthdayRequest = birthdayRequest;
    }

    public String getCountryUserRequest() {
        return countryUserRequest;
    }

    public void setCountryUserRequest(String countryUserRequest) {
        this.countryUserRequest = countryUserRequest;
    }

    public String getDescriptionUserRequest() {
        return descriptionUserRequest;
    }

    public void setDescriptionUserRequest(String descriptionUserRequest) {
        this.descriptionUserRequest = descriptionUserRequest;
    }


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getUsernameRequest() {
        return usernameRequest;
    }

    public void setUsernameRequest(String usernameRequest) {
        this.usernameRequest = usernameRequest;
    }

    public int getSouvenirId() {
        return souvenirId;
    }

    public void setSouvenirId(int souvenirId) {
        this.souvenirId = souvenirId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCountrySouvenir() {
        return countrySouvenir;
    }

    public void setCountrySouvenir(String countrySouvenir) {
        this.countrySouvenir = countrySouvenir;
    }

    public String getSouvenirName() {
        return souvenirName;
    }

    public void setSouvenirName(String souvenirName) {
        this.souvenirName = souvenirName;
    }

    public String getDescriptionSouvenir() {
        return descriptionSouvenir;
    }

    public void setDescriptionSouvenir(String descriptionSouvenir) {
        this.descriptionSouvenir = descriptionSouvenir;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

