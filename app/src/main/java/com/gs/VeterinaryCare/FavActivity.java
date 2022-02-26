package com.gs.VeterinaryCare;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.database.FirebaseDatabase;
import com.gs.VeterinaryCare.Adapters.AnimalCardAdapter;
import com.gs.VeterinaryCare.Adapters.FavPagerAdapter;
import com.gs.VeterinaryCare.DataResource.AnimalsData;
import static com.gs.VeterinaryCare.VeterinaryApplication.*;

import com.gs.VeterinaryCare.databinding.ActivityFavBinding;
public class FavActivity extends AppCompatActivity {

    RecyclerView favRecyclerView;
    AnimalCardAdapter animalCardAdapter;
    ViewPager2 favViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFavBinding binding = ActivityFavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FavPagerAdapter favPagerAdapter = new FavPagerAdapter(getSupportFragmentManager(), getLifecycle());
        favViewPager = binding.favViewPager;
        favViewPager.setAdapter(favPagerAdapter);
    }

}