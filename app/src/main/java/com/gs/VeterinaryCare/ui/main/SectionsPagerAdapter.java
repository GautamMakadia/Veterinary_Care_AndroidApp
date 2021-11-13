package com.gs.VeterinaryCare.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.gs.VeterinaryCare.R;
import com.gs.VeterinaryCare.fragments.animalsFragment;
import com.gs.VeterinaryCare.fragments.birdsFragment;
import com.gs.VeterinaryCare.fragments.petsFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.Animal, R.string.Pets, R.string.Birds};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fr = null;
        switch (position){
            case 0 :
                fr = new animalsFragment();
                break;

            case 1 :
                fr = new petsFragment();
                break;

            case 2 :
                fr = new birdsFragment();
                break;
        }

        assert fr != null;
        return fr;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}