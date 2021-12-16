package com.gs.VeterinaryCare.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.gs.VeterinaryCare.Adapters.AnimalCardAdapter;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;

public class PetFragment extends Fragment {
    RecyclerView recyclerView;
    AnimalCardAdapter petCardAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FirebaseRecyclerOptions<AnimalsData> options =
                new FirebaseRecyclerOptions.Builder<AnimalsData>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Animals").orderByChild("type").equalTo(2), AnimalsData.class)
                        .build();
        petCardAdapter = new AnimalCardAdapter(options);
        petCardAdapter.startListening();

        View view = inflater.inflate(R.layout.fragment_pet,container,false);

        recyclerView = view.findViewById(R.id.petsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(petCardAdapter);

        return view;
    }
}