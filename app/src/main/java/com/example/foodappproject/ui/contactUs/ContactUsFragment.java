package com.example.foodappproject.ui.contactUs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodappproject.R;
import com.example.foodappproject.database.DBContact;

public class ContactUsFragment extends Fragment {
    EditText txt_conName,txt_conEmail,txt_conPhone,txt_msg;
    Button contact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_contact_us, container, false);

        txt_conName=(EditText) view.findViewById(R.id.txt_con_fullName);
        txt_conEmail=(EditText) view.findViewById(R.id.txt_con_email);
        txt_conPhone=(EditText) view.findViewById(R.id.txt_con_phone);
        txt_msg=(EditText) view.findViewById(R.id.txt_con_message);

        contact=(Button) view.findViewById(R.id.btn_contact);

        DBContact helper=new DBContact(getContext());
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtConName=txt_conName.getText().toString();
                String txtConEmail=txt_conEmail.getText().toString();
                String txtConPhone=txt_conPhone.getText().toString();
                String txtMessage=txt_msg.getText().toString();

                Boolean ContactUs=helper.insertContact(txtConName,txtConEmail,txtConPhone,txtMessage);
                if (ContactUs==true){
                    Toast.makeText(getContext(), "Information is added.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(), "Information is not added.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}