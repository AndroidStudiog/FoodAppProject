package com.example.foodappproject.ui.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodappproject.R;
import com.example.foodappproject.WelcomeActivity;
import com.example.foodappproject.adapters.HomeHorAdapter;
import com.example.foodappproject.adapters.HomeVerAdapter;
import com.example.foodappproject.adapters.UpdateVerticalRec;
import com.example.foodappproject.databinding.FragmentHomeBinding;
import com.example.foodappproject.models.HomeHorModel;
import com.example.foodappproject.models.HomeVerModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Locale;

public class HomeFragment extends Fragment implements UpdateVerticalRec {
    RecyclerView hor_RecycleVew,ver_RecycleVew;
    SearchView searchView;
    ImageView person;
    ArrayList<HomeHorModel> list1;
    HomeHorAdapter adapter1;

    TextView name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        searchView=(SearchView) view.findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });

       /*
        name=(TextView) view.findViewById(R.id.name);

        Intent intent=getActivity().getIntent();
        String mail=intent.getStringExtra("email");
        name.setText(mail);
        */

        person=(ImageView) view.findViewById(R.id.person);

        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(getContext());

                builder.setIcon(R.drawable.man);
                builder.setTitle("Logout");
                builder.setMessage("Are you sure want to Logout this app.");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(getContext(), WelcomeActivity.class);
                        startActivity(intent);
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        //////////Horizontal RecycleView

        hor_RecycleVew=(RecyclerView) view.findViewById(R.id.home_hor_rec);

        list1=new ArrayList<>();

        list1.add(new HomeHorModel(R.drawable.c_pizza,"Pizza"));
        list1.add(new HomeHorModel(R.drawable.c_burger,"Burger"));
        list1.add(new HomeHorModel(R.drawable.c_fries,"Fries"));
        list1.add(new HomeHorModel(R.drawable.c_ice_cream,"Ice Cream"));
        list1.add(new HomeHorModel(R.drawable.c_sandwich,"Sandwich"));

        adapter1=new HomeHorAdapter(list1,getActivity(),this);
        hor_RecycleVew.setAdapter(adapter1);

        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        hor_RecycleVew.setLayoutManager(linearLayoutManager1);

        //////////Vertical RecycleView

        ver_RecycleVew=(RecyclerView) view.findViewById(R.id.home_ver_rec);

        ArrayList<HomeVerModel> list2=new ArrayList<>();

        HomeVerAdapter adapter2=new HomeVerAdapter(list2,getContext());
        ver_RecycleVew.setAdapter(adapter2);

        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        ver_RecycleVew.setLayoutManager(linearLayoutManager2);

        return view;
    }

    private void filter(String newText) {
        ArrayList<HomeHorModel> list3=new ArrayList<>();
        for (HomeHorModel item: list1){
            if(item.getName().toLowerCase(Locale.ROOT).contains(newText.toLowerCase(Locale.ROOT))){
                list3.add(item);
            }
        }

        adapter1.searchBox(list3);

    }

    @Override
    public void callBack(ArrayList<HomeVerModel> list, int position) {
        HomeVerAdapter adapter3=new HomeVerAdapter(list,getContext());
        ver_RecycleVew.setAdapter(adapter3);
    }

    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}