package com.gs.VeterinaryCare.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.gs.VeterinaryCare.Adapters.AnimalCardAdapter;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;

import java.util.ArrayList;

public class birdsFragment extends Fragment {

    RecyclerView recyclerView;
    AnimalCardAdapter animalCardAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.birds,container,false);

        recyclerView = view.findViewById(R.id.birds_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<AnimalsData> options =
                new FirebaseRecyclerOptions.Builder<AnimalsData>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Animals").orderByChild("type").equalTo(3),AnimalsData.class)
                        .build();

        animalCardAdapter = new AnimalCardAdapter(options);
        recyclerView.setAdapter(animalCardAdapter);
        animalCardAdapter.startListening();
        return view;
    }

}
