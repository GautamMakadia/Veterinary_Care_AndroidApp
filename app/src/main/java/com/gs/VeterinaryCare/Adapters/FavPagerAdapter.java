package com.gs.VeterinaryCare.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.gs.VeterinaryCare.fragments.FavFragment;

public class FavPagerAdapter extends FragmentStateAdapter {


    public FavPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return new FavFragment();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
