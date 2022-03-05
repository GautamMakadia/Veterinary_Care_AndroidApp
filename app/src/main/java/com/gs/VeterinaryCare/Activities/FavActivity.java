package com.gs.VeterinaryCare.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.gs.VeterinaryCare.Adapters.AnimalCardAdapter;
import com.gs.VeterinaryCare.Adapters.FavPagerAdapter;

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