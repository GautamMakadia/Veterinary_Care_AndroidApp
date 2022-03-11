package com.gs.VeterinaryCare.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.gs.VeterinaryCare.Adapters.FavPagerAdapter;
import com.gs.VeterinaryCare.databinding.ActivityFavBinding;

public class FavActivity extends AppCompatActivity {

    MaterialToolbar topAppBar;
    ViewPager2 favViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        ActivityFavBinding binding = ActivityFavBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FavPagerAdapter favPagerAdapter = new FavPagerAdapter(getSupportFragmentManager(), getLifecycle());
        favViewPager = binding.favViewPager;
        favViewPager.setAdapter(favPagerAdapter);

        topAppBar = binding.topAppToolBar;
        setSupportActionBar(topAppBar);
        topAppBar.setNavigationOnClickListener(view -> finish());

        AppBarLayout appBarLayout = binding.appBarLayout;
        ViewCompat.setOnApplyWindowInsetsListener(appBarLayout, (v, windowsInsets) -> {
            Insets insets = windowsInsets.getInsets(WindowInsetsCompat.Type.statusBars());
            appBarLayout.setPadding(insets.left, insets.top, insets.right, insets.bottom);

            return WindowInsetsCompat.CONSUMED;
        });
    }

}