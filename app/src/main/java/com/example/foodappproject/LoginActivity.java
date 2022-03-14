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

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    Button signIn;
    TextView signIn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=(EditText) findViewById(R.id.txt_login_email);
        password=(EditText) findViewById(R.id.txt_login_password);

        DBHelper helper=new DBHelper(this);

        signIn=(Button) findViewById(R.id.btn_signIn);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String Password=password.getText().toString();
                if (Email.equals("") || Password.equals("")){
                    Toast.makeText(LoginActivity.this, "Please fill all Field.", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean validate=helper.checkEmailAndPassword(Email,Password);
                    if (validate==true){
                        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "Login is Successfully.", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Login is not Successfully.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signIn_register=(TextView) findViewById(R.id.txt_sign_in_register);
        signIn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}