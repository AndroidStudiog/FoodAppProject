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
import com.example.foodappproject.models.PopularVerModel;

import java.util.ArrayList;

public class PopularVerAdapter extends RecyclerView.Adapter<PopularVerAdapter.ViewHolder> {
    ArrayList<PopularVerModel> list;
    Context context;

    public PopularVerAdapter(ArrayList<PopularVerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.popular_ver_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PopularVerModel mdl=list.get(position);
        holder.image.setImageResource(mdl.getImage());
        holder.name.setText(mdl.getName());
        holder.description.setText(mdl.getDescription());
        holder.rating.setText(mdl.getRating());
        holder.timing.setText(mdl.getTiming());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,description,rating,timing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.popular_ver_img);
            name=(TextView) itemView.findViewById(R.id.popular_ver_name);
            description=(TextView) itemView.findViewById(R.id.popular_ver_des);
            rating=(TextView) itemView.findViewById(R.id.popular_ver_rating);
            timing=(TextView) itemView.findViewById(R.id.popular_ver_time);
        }
    }
}