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
import com.example.foodappproject.models.NewVerModel;

import java.util.ArrayList;

public class NewVerAdapter extends RecyclerView.Adapter<NewVerAdapter.ViewHolder> {
    ArrayList<NewVerModel> list;
    Context context;

    public NewVerAdapter(ArrayList<NewVerModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.new_ver_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewVerModel mdl=list.get(position);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,description,rating,timing;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.new_ver_img);
            name=(TextView) itemView.findViewById(R.id.new_ver_name);
            description=(TextView) itemView.findViewById(R.id.new_ver_des);
            rating=(TextView) itemView.findViewById(R.id.new_ver_rating);
            timing=(TextView) itemView.findViewById(R.id.new_ver_time);
        }
    }
}