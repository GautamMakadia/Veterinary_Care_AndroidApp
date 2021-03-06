package com.gs.VeterinaryCare;

import android.app.Application;

import com.google.android.material.color.DynamicColors;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.gs.VeterinaryCare.DataResource.User;

public class VeterinaryApplication extends Application {

    private static User user;
    private static boolean isUserLoggedIn;

    public static void setUser(User user) {
        VeterinaryApplication.user = user;
    }

    public static void setIsUserLoggedIn(boolean isUserLoggedIn) {
        VeterinaryApplication.isUserLoggedIn = isUserLoggedIn;
    }

    public static User getUser() {
        return VeterinaryApplication.user;
    }

    public static boolean isUserLoggedIn() {
        return VeterinaryApplication.isUserLoggedIn;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DatabaseReference AnimalRef = FirebaseDatabase.getInstance().getReference().child("Animals");
        AnimalRef.keepSynced(true);
    }
}
