package com.example.foodappproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodappproject.R;
import com.example.foodappproject.adapters.HomeHorAdapter;
import com.example.foodappproject.adapters.HomeVerAdapter;
import com.example.foodappproject.databinding.FragmentHomeBinding;
import com.example.foodappproject.models.HomeHorModel;
import com.example.foodappproject.models.HomeVerModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView hor_RecycleVew, ver_RecycleVew;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //////////Horizontal RecycleView

        hor_RecycleVew = (RecyclerView) view.findViewById(R.id.home_hor_rec);

        ArrayList<HomeHorModel> list1 = new ArrayList<>();

        list1.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        list1.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        list1.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        list1.add(new HomeHorModel(R.drawable.pizza, "Pizza"));
        list1.add(new HomeHorModel(R.drawable.pizza, "Pizza"));

        HomeHorAdapter adapter1 = new HomeHorAdapter(list1, getContext());
        hor_RecycleVew.setAdapter(adapter1);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        hor_RecycleVew.setLayoutManager(linearLayoutManager1);

        //////////Vertical RecycleView

        ver_RecycleVew = (RecyclerView) view.findViewById(R.id.home_ver_rec);

        ArrayList<HomeVerModel> list2 = new ArrayList<>();

        list2.add(new HomeVerModel(R.drawable.food1, "Burger", "10:00 - 23:00", "5.0", "Min - $60"));
        list2.add(new HomeVerModel(R.drawable.food1, "Burger", "10:00 - 23:00", "5.0", "Min - $60"));
        list2.add(new HomeVerModel(R.drawable.food1, "Burger", "10:00 - 23:00", "5.0", "Min - $60"));
        list2.add(new HomeVerModel(R.drawable.food1, "Burger", "10:00 - 23:00", "5.0", "Min - $60"));
        list2.add(new HomeVerModel(R.drawable.food1, "Burger", "10:00 - 23:00", "5.0", "Min - $60"));

        HomeVerAdapter adapter2 = new HomeVerAdapter(list2, getContext());
        ver_RecycleVew.setAdapter(adapter2);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        ver_RecycleVew.setLayoutManager(linearLayoutManager2);

        return view;
    }
}