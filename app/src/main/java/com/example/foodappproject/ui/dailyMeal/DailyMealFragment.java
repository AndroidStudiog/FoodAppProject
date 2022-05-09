package com.example.foodappproject.ui.dailyMeal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodappproject.R;
import com.example.foodappproject.adapters.DailyMealAdapter;
import com.example.foodappproject.models.DailyMealModel;

import java.util.ArrayList;

public class DailyMealFragment extends Fragment {
    RecyclerView dailyMeal_recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_daily_meal, container, false);

        dailyMeal_recyclerView=(RecyclerView) view.findViewById(R.id.daily_meal_recyclerview);

        ArrayList<DailyMealModel> list=new ArrayList<>();
        list.add(new DailyMealModel(R.drawable.pizza,"Pizza","Description","20% OFF","pizza"));
        list.add(new DailyMealModel(R.drawable.burger,"Burger","Description","20% OFF","burger"));
        list.(new DailyMealModel(R.drawable.ice_cream,"Ice Cream","Description","20% OFF","ice_cream"));

        DailyMealAdapter adapter=new DailyMealAdapter(list,getContext());
        dailyMeal_recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        dailyMeal_recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}