package com.example.foodappproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodappproject.R;
import com.example.foodappproject.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    RecyclerView recycleVew;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recycleVew=(RecyclerView) view.findViewById(R.id.home_hor_rec);

        return view;
    }
}