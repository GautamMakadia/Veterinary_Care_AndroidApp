package com.gs.VeterinaryCare;

import android.app.Application;

import com.google.android.material.color.DynamicColors;

public class VeterinaryApplication extends Application {
    @Override
    public void onCreate() {
        DynamicColors.applyToActivitiesIfAvailable(this);
        super.onCreate();
    }
}
