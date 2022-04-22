package com.example.foodappproject.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.foodappproject.tabsFragments.FeaturedFragment;
import com.example.foodappproject.tabsFragments.NewFragment;
import com.example.foodappproject.tabsFragments.PopularFragment;

public class FragmentAdapter extends FragmentStateAdapter {


    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FeaturedFragment();
            case 1:
                return new PopularFragment();
            case 2:
                return new NewFragment();
        }
        return new FeaturedFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}