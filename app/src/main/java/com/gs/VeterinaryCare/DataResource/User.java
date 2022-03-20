package com.gs.VeterinaryCare.DataResource;

public class User {
    private String userName;
    private String userEmail;
    private String userID;
    private String userImage;

    public User(){}

    public User(String userName, String userEmail, String userID, String userImage) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userID = userID;
        this.userImage = userImage;
    }

    public User(String userID, String userEmail, String userName) {
        this.userID = userID;
        this.userEmail = userEmail;
        this.userName = userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserImage() {
        return userImage;
    }

}