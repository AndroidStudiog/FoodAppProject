package com.example.foodappproject.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodappproject.OrderDetailActivity;
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
        holder.cart_detailed.setText(mdl.getAdd_to_cart());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.cart_detailed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Added to a Cart.", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context, OrderDetailActivity.class);
                        intent.putExtra("image",mdl.getImage());
                        intent.putExtra("name",mdl.getName());
                        intent.putExtra("description",mdl.getDescription());
                        intent.putExtra("price",mdl.getPrice());
                        intent.putExtra("type",3);
                        context.startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,description,rating,timing,price,cart_detailed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.detailed_img);
            name=(TextView) itemView.findViewById(R.id.detailed_name);
            description=(TextView) itemView.findViewById(R.id.detailed_description);
            rating=(TextView) itemView.findViewById(R.id.detailed_rating);
            timing=(TextView) itemView.findViewById(R.id.detailed_time);
            price=(TextView) itemView.findViewById(R.id.detailed_price);
            cart_detailed=(TextView) itemView.findViewById(R.id.detailed_add_to_cart);
        }
    }
}