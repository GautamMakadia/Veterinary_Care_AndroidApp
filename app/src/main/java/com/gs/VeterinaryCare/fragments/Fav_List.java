package com.gs.VeterinaryCare.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.gs.VeterinaryCare.databinding.ActivityFavListBinding;

public class Fav_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFavListBinding binding = ActivityFavListBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        MaterialToolbar materialToolbar = binding.topAppToolBar;
        materialToolbar.setNavigationOnClickListener(view -> finish());
    }

}