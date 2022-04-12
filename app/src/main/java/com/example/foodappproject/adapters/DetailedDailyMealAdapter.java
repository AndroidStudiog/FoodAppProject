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
import com.example.foodappproject.models.DetailedDailyMealModel;

import java.util.ArrayList;

public class DetailedDailyMealAdapter extends RecyclerView.Adapter<DetailedDailyMealAdapter.ViewHolder> {
    ArrayList<DetailedDailyMealModel> list;
    Context context;

    public DetailedDailyMealAdapter(ArrayList<DetailedDailyMealModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DetailedDailyMealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.detailed_daily_meal_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailedDailyMealAdapter.ViewHolder holder, int position) {
        DetailedDailyMealModel mdl=list.get(position);
        holder.image.setImageResource(mdl.getImage());
        holder.name.setText(mdl.getName());
        holder.description.setText(mdl.getDescription());
        holder.rating.setText(mdl.getRating());
        holder.timing.setText(mdl.getTiming());
        holder.price.setText(mdl.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,description,rating,timing,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.detailed_img);
            name=(TextView) itemView.findViewById(R.id.detailed_name);
            description=(TextView) itemView.findViewById(R.id.detailed_description);
            rating=(TextView) itemView.findViewById(R.id.detailed_rating);
            timing=(TextView) itemView.findViewById(R.id.detailed_time);
            price=(TextView) itemView.findViewById(R.id.detailed_price);
        }
    }
}