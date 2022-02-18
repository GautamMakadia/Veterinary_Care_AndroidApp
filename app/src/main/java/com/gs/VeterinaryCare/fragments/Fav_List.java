package com.gs.VeterinaryCare.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.database.FirebaseDatabase;
import com.gs.VeterinaryCare.Adapters.AnimalCardAdapter;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import static com.gs.VeterinaryCare.VeterinaryApplication.*;
import com.gs.VeterinaryCare.databinding.ActivityFavListBinding;

public class Fav_List extends AppCompatActivity {

    RecyclerView favRecyclerView;
    AnimalCardAdapter animalCardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseRecyclerOptions<AnimalsData> options =
                new FirebaseRecyclerOptions.Builder<AnimalsData>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Users").child(getUser().getUserID()).child("Favourites"), AnimalsData.class)
                        .build();

        ActivityFavListBinding binding = ActivityFavListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialToolbar materialToolbar = binding.topAppToolBar;
        materialToolbar.setNavigationOnClickListener(view -> finish());

        favRecyclerView = binding.favAnimalRecyclerview;

        animalCardAdapter = new AnimalCardAdapter(options);
        animalCardAdapter.startListening();
        favRecyclerView.setAdapter(animalCardAdapter);
        favRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}