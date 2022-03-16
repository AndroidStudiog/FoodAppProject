package com.example.foodappproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodappproject.R;
import com.example.foodappproject.models.HomeVerModel;

import java.util.ArrayList;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {
    ArrayList<HomeVerModel> list;
    Context context;

    public HomeVerAdapter(ArrayList<HomeVerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.home_vertical_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeVerModel mdl=list.get(position);
        holder.image.setImageResource(mdl.getImage());
        holder.text.setText(mdl.getName());
        holder.timing.setText(mdl.getTiming());
        holder.rating.setText(mdl.getRating());
        holder.price.setText(mdl.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text,timing,rating,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.ver_img);
            text=(TextView) itemView.findViewById(R.id.productName);
            timing=(TextView) itemView.findViewById(R.id.time);
            rating=(TextView) itemView.findViewById(R.id.rate);
            price=(TextView) itemView.findViewById(R.id.price);
        }
    }
}