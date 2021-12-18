package com.gs.VeterinaryCare.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.gs.VeterinaryCare.fragments.AnimalFragment;
import com.gs.VeterinaryCare.fragments.BirdFragment;
import com.gs.VeterinaryCare.fragments.PetFragment;

public class ViewpagerAdapter extends FragmentStateAdapter {
    public ViewpagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fr = null;
        switch (position){
            case 0 :
                fr = new AnimalFragment();
                break;

            case 1 :
                fr = new PetFragment();
                break;

            case 2 :
                fr = new BirdFragment();
                break;
        }

        assert fr != null;
        return fr;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
