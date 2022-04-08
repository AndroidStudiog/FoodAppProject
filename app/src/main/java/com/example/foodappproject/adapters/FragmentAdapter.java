package com.example.foodappproject.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foodappproject.tabsFragments.FeaturedFragment;
import com.example.foodappproject.tabsFragments.NewFragment;
import com.example.foodappproject.tabsFragments.PopularFragment;

public class FragmentAdapter extends FragmentPagerAdapter {


    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FeaturedFragment();
            case 1:
                return new PopularFragment();
            case 2:
                return new NewFragment();
            default:
                return new FeaturedFragment();
        }
    }
    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title=null;
        if (position==0){
            title="FEATURED";
        }
        else if (position==1){
            title="POPULAR";
        }
        else if (position==2){
            title="NEW";
        }
        return title;
    }
}