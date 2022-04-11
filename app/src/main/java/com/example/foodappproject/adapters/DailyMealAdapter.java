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
import com.example.foodappproject.models.DailyMealModel;

import java.util.ArrayList;

public class DailyMealAdapter extends RecyclerView.Adapter<DailyMealAdapter.ViewHolder> {
    ArrayList<DailyMealModel> list;
    Context context;

    public DailyMealAdapter(ArrayList<DailyMealModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DailyMealAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.daily_meal_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyMealAdapter.ViewHolder holder, int position) {
        DailyMealModel mdl=list.get(position);
        holder.image.setImageResource(mdl.getImage());
        holder.name.setText(mdl.getName());
        holder.description.setText(mdl.getDescription());
        holder.discount.setText(mdl.getDiscount());
/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailedDailyMealActivity.class);
                intent.putExtra("type",mdl.getType());
                context.startActivity(intent);
            }
        });
 */
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name,description,discount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=(ImageView) itemView.findViewById(R.id.meal_img);
            name=(TextView) itemView.findViewById(R.id.meal_product_name);
            description=(TextView) itemView.findViewById(R.id.meal_description);
            discount=(TextView) itemView.findViewById(R.id.meal_discount);
        }
    }
}