package com.gs.VeterinaryCare.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.gs.VeterinaryCare.DataResource.AnimalsData;
import com.gs.VeterinaryCare.R;

import java.util.ArrayList;

public class petsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<AnimalsData> petDataArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pets,container,false);
    }
}
