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

public class birdsFragment extends Fragment {
    ArrayList<AnimalsData> birdsDataArrayList;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.birds,container,false);

        recyclerView = view.findViewById(R.id.birds_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        birdsDataArrayList = new ArrayList<>();

        AnimalsData ad1 = new AnimalsData(R.drawable.tiger,"Tiger","https://veterinarycare-eb421.web.app/Animals_Catagory/Animals/Tiger.html");
        birdsDataArrayList.add(ad1);

        recyclerView.setAdapter(new AnimalCardAdapter(birdsDataArrayList, view.getContext()));

        return view;
    }
}
