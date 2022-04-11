package com.example.foodappproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodappproject.R;
import com.example.foodappproject.models.HomeVerModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

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

        final int mImage=mdl.getImage();
        final String mName=mdl.getName();
        final String mTiming=mdl.getTiming();
        final String mRating=mdl.getRating();
        final String mPrice=mdl.getPrice();

        holder.image.setImageResource(mdl.getImage());
        holder.text.setText(mdl.getName());
        holder.timing.setText(mdl.getTiming());
        holder.rating.setText(mdl.getRating());
        holder.price.setText(mdl.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            ImageView bottom_sheet_image;
            TextView bottom_sheet_name,bottom_sheet_timing,bottom_sheet_rating,bottom_sheet_price;
            Button bottom_sheet_add_to_cart;

            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(context,R.style.BottomSheetTheme);

                View sheetView=LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null);

                bottom_sheet_image=(ImageView) sheetView.findViewById(R.id.bottom_sheet_img);
                bottom_sheet_name=(TextView) sheetView.findViewById(R.id.bottom_sheet_name);
                bottom_sheet_timing=(TextView) sheetView.findViewById(R.id.bottom_sheet_time);
                bottom_sheet_rating=(TextView) sheetView.findViewById(R.id.bottom_sheet_rating);
                bottom_sheet_price=(TextView) sheetView.findViewById(R.id.bottom_sheet_price);

                bottom_sheet_image.setImageResource(mImage);
                bottom_sheet_name.setText(mName);
                bottom_sheet_timing.setText(mTiming);
                bottom_sheet_rating.setText(mRating);
                bottom_sheet_price.setText(mPrice);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();

                bottom_sheet_add_to_cart=(Button) sheetView.findViewById(R.id.bottom_sheet_add_to_cart);
                bottom_sheet_add_to_cart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Added to a Cart.", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
            }
        });
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