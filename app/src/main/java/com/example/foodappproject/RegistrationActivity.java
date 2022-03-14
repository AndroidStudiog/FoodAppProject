package com.example.foodappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodappproject.Database.DBHelper;

public class RegistrationActivity extends AppCompatActivity {
    EditText name,email,password;
    Button register;
    TextView register_sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name=(EditText) findViewById(R.id.txt_reg_fullName);
        email=(EditText) findViewById(R.id.txt_reg_email);
        password=(EditText)findViewById(R.id.txt_reg_password);

        DBHelper helper=new DBHelper(this);

        register=(Button) findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name=name.getText().toString();
                String Email=email.getText().toString();
                String Password=password.getText().toString();
                if (Name.equals("") || Email.equals("") || Password.equals("")){
                    Toast.makeText(RegistrationActivity.this, "Please fill all Field.", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean i=helper.checkEmail(Email);
                    if (i==false){
                        boolean checkInsert=helper.insertUserData(Name,Email,Password);
                        if (checkInsert==true){
                            Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(RegistrationActivity.this, "Account is created.", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(RegistrationActivity.this, "Your Account have been not Created.", Toast.LENGTH_SHORT);
                        }
                    }
                    else{
                        Toast.makeText(RegistrationActivity.this, "Please choose another Email.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        register_sign_in=(TextView) findViewById(R.id.txt_register_sign_in);
        register_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}