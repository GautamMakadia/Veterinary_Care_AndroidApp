package com.gs.VeterinaryCare.DataResource;

import android.net.Uri;

public class User {
    private String UsrName;
    private String UsrEmail;
    private String UsrID;
    private Uri UsrImage;

    public User(String usrName, String usrEmail, String usrID, Uri usrImage) {
        this.UsrName = usrName;
        this.UsrEmail = usrEmail;
        this.UsrID = usrID;
        this.UsrImage = usrImage;
    }

    public String getUsrName() {
        return UsrName;
    }


    public String getUsrEmail() {
        return UsrEmail;
    }


    public String getUsrID() {
        return UsrID;
    }


    public Uri getUsrImage() {
        return UsrImage;
    }

}