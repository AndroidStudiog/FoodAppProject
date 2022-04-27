package com.example.foodappproject.ui.favourite;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.foodappproject.MainActivity;
import com.example.foodappproject.R;
import com.example.foodappproject.adapters.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class FavouriteFragment extends Fragment {
    TextView more;
    TabLayout tab_layout;
    ViewPager2 view_pager2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favourite, container, false);

        more=(TextView) view.findViewById(R.id.viewMore);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), MainActivity.class);
                getContext().startActivity(intent);
            }
        });

        view_pager2 = (ViewPager2) view.findViewById(R.id.viewPager2);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentAdapter adapter = new FragmentAdapter(fragmentManager,getLifecycle());
        view_pager2.setAdapter(adapter);

        tab_layout = (TabLayout) view.findViewById(R.id.tabLayout);

        tab_layout.addTab(tab_layout.newTab().setText("Featured"));
        tab_layout.addTab(tab_layout.newTab().setText("Popular"));
        tab_layout.addTab(tab_layout.newTab().setText("New"));

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}