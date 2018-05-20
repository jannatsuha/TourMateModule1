package com.example.admin.tourmatemodule1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnlogin,btnsignup;
    EditText etEmail,etPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail=findViewById(R.id.etEmail);
        etPass=findViewById(R.id.etPass);
        btnlogin=findViewById(R.id.btnLogin);
        btnsignup=findViewById(R.id.btnSignup);

    }

    public void signup(View view) {
    }

    public void login(View view) {
    }
}
