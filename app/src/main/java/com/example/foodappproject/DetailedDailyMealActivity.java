package com.example.foodappproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.foodappproject.adapters.DetailedDailyMealAdapter;
import com.example.foodappproject.models.DetailedDailyMealModel;

import java.util.ArrayList;

public class DetailedDailyMealActivity extends AppCompatActivity {
    RecyclerView detailed_dailyMeal_recyclerView;
    ImageView image;
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);
        Intent intent=getIntent();
        type=intent.getStringExtra("type");

        detailed_dailyMeal_recyclerView=(RecyclerView) findViewById(R.id.detailed_rec);

        image=(ImageView) findViewById(R.id.detailed_img);

        ArrayList<DetailedDailyMealModel> list=new ArrayList<>();

        if (type!=null && type.equalsIgnoreCase("pizza")){
            image.setImageResource(R.drawable.pizza);
            list.add(new DetailedDailyMealModel(R.drawable.pizza,"Pizza","Description","30% OFF","10:00 - 7:00","120.0"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza_bottle,"Pizza_bottle","Description","30% OFF","10:00 - 7:00","120.0"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza,"Pizza","Description","30% OFF","10:00 - 7:00","120.0"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza,"Pizza","Description","30% OFF","10:00 - 7:00","120.0"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza_bottle,"Pizza_bottle","Description","30% OFF","10:00 - 7:00","120.0"));
            list.add(new DetailedDailyMealModel(R.drawable.pizza,"Pizza","Description","30% OFF","10:00 - 7:00","120.0"));
        }
        if (type!=null && type.equalsIgnoreCase("burger")){
            image.setImageResource(R.drawable.burger);
            list.add(new DetailedDailyMealModel(R.drawable.burger,"Burger","Description","30% OFF","10:00 - 7:00","120.0"));
            list.add(new DetailedDailyMealModel(R.drawable.burger_bottle,"Burger bottle","Description","30% OFF","10:00 - 7:00","120.0"));
            list.add(new DetailedDailyMealModel(R.drawable.burger,"Burger","Description","30% OFF","10:00 - 7:00","120.0"));
        }
        if (type!=null && type.equalsIgnoreCase("ice_cream")){
            image.setImageResource(R.drawable.ice_cream);
            list.add(new DetailedDailyMealModel(R.drawable.ice_cream,"Ice Cream","Description","30% OFF","10:00 - 7:00","120.0"));
            list.add(new DetailedDailyMealModel(R.drawable.ice_cream,"Ice Cream","Description","30% OFF","10:00 - 7:00","120.0"));
            list.add(new DetailedDailyMealModel(R.drawable.ice_cream,"Ice Cream","Description","30% OFF","10:00 - 7:00","120.0"));
        }

        DetailedDailyMealAdapter adapter=new DetailedDailyMealAdapter(list,this);
        detailed_dailyMeal_recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        detailed_dailyMeal_recyclerView.setLayoutManager(linearLayoutManager);
    }
}