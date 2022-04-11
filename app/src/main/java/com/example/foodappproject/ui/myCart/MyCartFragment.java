package com.example.foodappproject.ui.myCart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodappproject.R;
import com.example.foodappproject.adapters.CartAdapter;
import com.example.foodappproject.models.CartModel;

import java.util.ArrayList;

public class MyCartFragment extends Fragment {
    RecyclerView cart_recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_my_cart, container, false);

        cart_recyclerView=(RecyclerView) view.findViewById(R.id.cart_rec);

        ArrayList<CartModel> list=new ArrayList<>();
        list.add(new CartModel(R.drawable.pizza,"Pizza","5.0","60"));
        list.add(new CartModel(R.drawable.burger,"Burger","5.1","70"));
        list.add(new CartModel(R.drawable.ice_cream,"Ice Cream","5.2","80"));
        list.add(new CartModel(R.drawable.pizza,"Pizza","5.2","90"));
        list.add(new CartModel(R.drawable.pizza_bottle,"Pizza Bottle","5.4","120"));

        CartAdapter adapter1=new CartAdapter(list,getContext());
        cart_recyclerView.setAdapter(adapter1);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        cart_recyclerView.setLayoutManager(linearLayoutManager);

        return view;
    }
}