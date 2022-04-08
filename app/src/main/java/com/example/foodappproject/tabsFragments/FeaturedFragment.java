package com.example.foodappproject.tabsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodappproject.R;
import com.example.foodappproject.adapters.FeaturedHorAdapter;
import com.example.foodappproject.models.FeaturedHorModel;

import java.util.ArrayList;

public class FeaturedFragment extends Fragment {
    RecyclerView featured_hor_recyclerView,featured_ver_recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_featured, container, false);

        // Featured Hor RecyclerView

        featured_hor_recyclerView=(RecyclerView) view.findViewById(R.id.featured_hor_rec);

        ArrayList<FeaturedHorModel> list1=new ArrayList<>();
        list1.add(new FeaturedHorModel(R.drawable.pizza_bottle,"Featured 1","Description 1"));
        list1.add(new FeaturedHorModel(R.drawable.burger,"Featured 2","Description 2"));
        list1.add(new FeaturedHorModel(R.drawable.ice_cream,"Featured 3","Description 3"));
        list1.add(new FeaturedHorModel(R.drawable.burger,"Featured 3","Description 3"));
        list1.add(new FeaturedHorModel(R.drawable.pizza_bottle,"Featured 3","Description 3"));

        FeaturedHorAdapter adapter1=new FeaturedHorAdapter(list1,getContext());
        featured_hor_recyclerView.setAdapter(adapter1);

        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        featured_hor_recyclerView.setLayoutManager(linearLayoutManager1);

        return view;
    }
}