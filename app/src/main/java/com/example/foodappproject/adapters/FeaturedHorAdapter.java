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
import com.example.foodappproject.models.FeaturedHorModel;

import java.util.ArrayList;


public class FeaturedHorAdapter extends RecyclerView.Adapter<FeaturedHorAdapter.ViewHolder>{
    ArrayList<FeaturedHorModel> list;
    Context context;

    public FeaturedHorAdapter(ArrayList<FeaturedHorModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.featured_hor_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FeaturedHorModel mdl=list.get(position);
        holder.image.setImageResource(mdl.getImage());
        holder.description.setText(mdl.getDescription());
        holder.name.setText(mdl.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView description,name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.feature_img);
            description=(TextView) itemView.findViewById(R.id.feature_des);
            name=(TextView) itemView.findViewById(R.id.feature_name);
        }
    }
}