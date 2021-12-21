package com.gs.VeterinaryCare.DataResource;

import android.net.Uri;

public class User {
    private String usrName;
    private String usrEmail;
    private String usrID;
    private Uri usrImage;

    public User(String usrName, String usrEmail, String usrID, Uri usrImage) {
        this.usrName = usrName;
        this.usrEmail = usrEmail;
        this.usrID = usrID;
        this.usrImage = usrImage;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public void setUsrID(String usrID) {
        this.usrID = usrID;
    }

    public void setUsrImage(Uri usrImage) {
        this.usrImage = usrImage;
    }

    public String getUsrName() {
        return usrName;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public String getUsrID() {
        return usrID;
    }

    public Uri getUsrImage() {
        return usrImage;
    }

}