package com.example.foodappproject.ui.aboutUs;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodappproject.R;

public class AboutUsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Button share;
        TextView des;

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_about_us, container, false);

        share=(Button) view.findViewById(R.id.btnShare);
        des=(TextView) view.findViewById(R.id.txtdes);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data=des.getText().toString();

                Intent send=new Intent();
                send.setAction(Intent.ACTION_SEND);
                send.setType("text/plain");
                send.putExtra(Intent.EXTRA_TEXT,data);

                startActivity(send);
            }
        });

        return view;
    }
}