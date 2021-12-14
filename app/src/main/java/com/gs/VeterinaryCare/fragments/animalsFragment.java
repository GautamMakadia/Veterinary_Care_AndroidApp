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
import com.google.firebase.database.Query;
import com.gs.VeterinaryCare.Adapters.AnimalCardAdapter;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;



public class animalsFragment extends Fragment {

    RecyclerView recyclerView;
    AnimalCardAdapter animalCardAdapter;

    @Override
    public  View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_animmals_recycler_view,container,false);


        recyclerView = (RecyclerView) view.findViewById(R.id.animalRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<AnimalsData> options =
                new FirebaseRecyclerOptions.Builder<AnimalsData>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Animals").orderByChild("type").equalTo(1), AnimalsData.class)
                        .build();

        animalCardAdapter = new AnimalCardAdapter(options);
        recyclerView.setAdapter(animalCardAdapter);
        animalCardAdapter.startListening();

        return view;
    }

}
