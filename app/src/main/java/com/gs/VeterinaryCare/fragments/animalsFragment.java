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

import com.gs.VeterinaryCare.Adapters.AnimalCardAdapter;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;

import java.util.ArrayList;


public class animalsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<AnimalsData> animalsDataArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        View view = inflater.inflate(R.layout.fragment_animmals_recycler_view,container,false);

        recyclerView = view.findViewById(R.id.animalRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        animalsDataArrayList = new ArrayList<>();

        AnimalsData ad1 = new AnimalsData(R.drawable.tiger,"Tiger", "https://veterinarycare-eb421.web.app/Animals_Catagory/Animals/Tiger.html");
        animalsDataArrayList.add(ad1);

        AnimalsData ad2 = new AnimalsData(R.drawable.tiger,"Tiger","https://veterinarycare-eb421.web.app/Animals_Catagory/Animals/Tiger.html");
        animalsDataArrayList.add(ad2);

        AnimalsData ad3 = new AnimalsData(R.drawable.tiger,"Tiger", "https://veterinarycare-eb421.web.app/Animals_Catagory/Animals/Tiger.html");
        animalsDataArrayList.add(ad3);

        AnimalsData ad4 = new AnimalsData(R.drawable.tiger,"Tiger", "https://veterinarycare-eb421.web.app/Animals_Catagory/Animals/Tiger.html");
        animalsDataArrayList.add(ad4);

        AnimalsData ad5 = new AnimalsData(R.drawable.tiger,"Tiger", "https://veterinarycare-eb421.web.app/Animals_Catagory/Animals/Tiger.html");
        animalsDataArrayList.add(ad5);

        AnimalsData ad6 = new AnimalsData(R.drawable.tiger,"Tiger", "https://veterinarycare-eb421.web.app/Animals_Catagory/Animals/Tiger.html");
        animalsDataArrayList.add(ad6);

        recyclerView.setAdapter(new AnimalCardAdapter(animalsDataArrayList, view.getContext()));

        return view;
    }
}
