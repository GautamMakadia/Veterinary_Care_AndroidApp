package com.gs.VeterinaryCare;

import android.app.Application;

import com.google.android.material.color.DynamicColors;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VeterinaryApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        DatabaseReference AnimalRef = FirebaseDatabase.getInstance().getReference("Animals");
        AnimalRef.keepSynced(true);
    }
}
