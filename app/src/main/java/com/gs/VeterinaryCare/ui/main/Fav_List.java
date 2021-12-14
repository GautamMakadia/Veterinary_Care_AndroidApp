package com.gs.VeterinaryCare.ui.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.gs.VeterinaryCare.R;
import com.gs.VeterinaryCare.databinding.ActivityFavListBinding;

public class Fav_List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFavListBinding binding = ActivityFavListBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        MaterialToolbar materialToolbar = binding.topAppToolBar;
        materialToolbar.setNavigationOnClickListener(view -> {
            finish();
        });
    }

}