package com.gs.VeterinaryCare.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gs.VeterinaryCare.Adapters.AnimalCardAdapter;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;

import java.util.ArrayList;

public class petsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<AnimalsData> petDataArrayList;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pets,container,false);

        recyclerView = view.findViewById(R.id.petsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        petDataArrayList = new ArrayList<>();

        AnimalsData ad1 = new AnimalsData(R.drawable.tiger,"Tiger","https://veterinarycare-eb421.web.app/Animals_Catagory/Animals/Tiger.html");
        petDataArrayList.add(ad1);

        recyclerView.setAdapter( new AnimalCardAdapter(petDataArrayList,view.getContext()));

        return view;
    }
}
