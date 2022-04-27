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
import com.example.foodappproject.models.NewHorModel;

import java.util.ArrayList;

public class NewHorAdapter extends RecyclerView.Adapter<NewHorAdapter.ViewHolder> {
    ArrayList<NewHorModel> list;
    Context context;

    public NewHorAdapter(ArrayList<NewHorModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.new_hor_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewHorModel mdl=list.get(position);
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
            image=(ImageView) itemView.findViewById(R.id.new_img);
            description=(TextView) itemView.findViewById(R.id.new_des);
            name=(TextView) itemView.findViewById(R.id.new_name);
        }
    }
}