package com.gs.VeterinaryCare.fragments;

import static com.gs.VeterinaryCare.VeterinaryApplication.getUser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.gs.VeterinaryCare.Adapters.AnimalCardAdapter;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.databinding.FragmentFavBinding;

public class FavFragment extends Fragment {
    RecyclerView favRecyclerView;

    public FavFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentFavBinding binding = FragmentFavBinding.inflate(getLayoutInflater());

        FirebaseRecyclerOptions<AnimalsData> options =
                new FirebaseRecyclerOptions.Builder<AnimalsData>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Users").child(getUser().getUserID()).child("Favourites"), AnimalsData.class)
                        .build();

        AnimalCardAdapter animalCardAdapter = new AnimalCardAdapter(options);
        animalCardAdapter.startListening();
        favRecyclerView = binding.favAnimalRecyclerview;
        favRecyclerView.setAdapter(animalCardAdapter);
        favRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return binding.getRoot();
    }
}