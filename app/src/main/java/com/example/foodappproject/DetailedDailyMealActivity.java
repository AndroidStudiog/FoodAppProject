package com.example.foodappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.foodappproject.adapters.DetailedDailyMealAdapter;
import com.example.foodappproject.models.DetailedDailyMealModel;
import com.example.foodappproject.ui.myCart.MyCartFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DetailedDailyMealActivity extends AppCompatActivity {
    RecyclerView detailed_dailyMeal_recyclerView;
    ImageView image;
    String type;
    FloatingActionButton carts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        carts=(FloatingActionButton) findViewById(R.id.carts);
        carts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailedDailyMealActivity.this, MyCartFragment.class);
            }
        });

        Intent intent=getIntent();
        type=intent.getStringExtra("type");

        detailed_dailyMeal_recyclerView=(RecyclerView) findViewById(R.id.detailed_rec);

        image=(ImageView) findViewById(R.id.detailed_img);

        ArrayList<DetailedDailyMealModel> list=new ArrayList<>();

        if (type!=null && type.equalsIgnoreCase("pizza")){
            image.setImageResource(R.drawable.pizza);
            list.add(new DetailedDailyMealModel(R.drawable.pizza,"Pizza","Description","30% OFF","10:00 - 7:00","120","ADD TO CART"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza_bottle,"Pizza_bottle","Description","30% OFF","10:00 - 7:00","120","ADD TO CART"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza,"Pizza","Description","30% OFF","10:00 - 7:00","120","ADD TO CART"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza,"Pizza","Description","30% OFF","10:00 - 7:00","120","ADD TO CART"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza_bottle,"Pizza_bottle","Description","30% OFF","10:00 - 7:00","120","ADD TO CART"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza,"Pizza","Description","30% OFF","10:00 - 7:00","120","ADD TO CART"));
        }
        if (type!=null && type.equalsIgnoreCase("burger")){
            image.setImageResource(R.drawable.burger);
            list.add(new DetailedDailyMealModel(R.drawable.burger,"Burger","Description","30% OFF","10:00 - 7:00","130","ADD TO CART"));
            list.add(new DetailedDailyMealModel(R.drawable.burger_bottle,"Burger bottle","Description","30% OFF","10:00 - 7:00","130","ADD TO CART"));
            list.add(new DetailedDailyMealModel(R.drawable.burger,"Burger","Description","30% OFF","10:00 - 7:00","130","ADD TO CART"));
        }
        if (type!=null && type.equalsIgnoreCase("ice_cream")){
            image.setImageResource(R.drawable.ice_cream);
            list.add(new DetailedDailyMealModel(R.drawable.ice_cream,"Ice Cream","Description","30% OFF","10:00 - 7:00","150","ADD TO CART"));
            list.add(new DetailedDailyMealModel(R.drawable.ice_cream,"Ice Cream","Description","30% OFF","10:00 - 7:00","150","ADD TO CART"));
            list.add(new DetailedDailyMealModel(R.drawable.ice_cream,"Ice Cream","Description","30% OFF","10:00 - 7:00","150","ADD TO CART"));
        }

        DetailedDailyMealAdapter adapter=new DetailedDailyMealAdapter(list,this);
        detailed_dailyMeal_recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        detailed_dailyMeal_recyclerView.setLayoutManager(linearLayoutManager);
    }
}