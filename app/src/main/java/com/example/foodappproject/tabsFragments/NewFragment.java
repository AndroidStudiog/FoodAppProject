package com.example.foodappproject.tabsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodappproject.R;
import com.example.foodappproject.adapters.NewHorAdapter;
import com.example.foodappproject.adapters.NewVerAdapter;
import com.example.foodappproject.models.NewHorModel;
import com.example.foodappproject.models.NewVerModel;

import java.util.ArrayList;

public class NewFragment extends Fragment {

    RecyclerView new_hor_recyclerView,new_ver_recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_new, container, false);

        // New Hor RecyclerView

        new_hor_recyclerView=(RecyclerView) view.findViewById(R.id.new_hor_rec);

        ArrayList<NewHorModel> list1=new ArrayList<>();
        list1.add(new NewHorModel(R.drawable.ice_cream,"Description 1","New 1"));
        list1.add(new NewHorModel(R.drawable.burger,"Description 2","New 2"));
        list1.add(new NewHorModel(R.drawable.ice_cream,"Description 3","New 3"));
        list1.add(new NewHorModel(R.drawable.pizza,"Description 4","New 4"));
        list1.add(new NewHorModel(R.drawable.pizza_bottle,"Description 5","New 5"));

        NewHorAdapter adapter1=new NewHorAdapter(list1,getContext());
        new_hor_recyclerView.setAdapter(adapter1);

        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        new_hor_recyclerView.setLayoutManager(linearLayoutManager1);

        // New Ver RecyclerView

        new_ver_recyclerView=(RecyclerView) view.findViewById(R.id.new_ver_rec);

        ArrayList<NewVerModel> list2=new ArrayList<>();
        list2.add(new NewVerModel(R.drawable.ice_cream,"New 1","Description 1","5.0","10:00 - 7:00"));
        list2.add(new NewVerModel(R.drawable.burger,"New 2","Description 2","5.0","10:00 - 7:00"));
        list2.add(new NewVerModel(R.drawable.ice_cream,"New 3","Description 3","5.0","10:00 - 7:00"));
        list2.add(new NewVerModel(R.drawable.pizza,"New 4","Description 4","5.0","10:00 - 7:00"));
        list2.add(new NewVerModel(R.drawable.pizza_bottle,"New 5","Description 5","5.0","10:00 - 7:00"));

        NewVerAdapter adapter2=new NewVerAdapter(list2,getContext());
        new_ver_recyclerView.setAdapter(adapter2);

        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        new_ver_recyclerView.setLayoutManager(linearLayoutManager2);

        return view;
    }
}