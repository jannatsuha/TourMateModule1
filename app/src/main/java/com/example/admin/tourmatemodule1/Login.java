package com.example.admin.tourmatemodule1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    Button btnlogin, btnsignup;
    EditText etEmail, etPass;
    TextView errortxt;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        btnlogin = findViewById(R.id.btnLogin);
        btnsignup = findViewById(R.id.btnSignup);
        errortxt = findViewById(R.id.errorText);




    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth = FirebaseAuth.getInstance();

        user = FirebaseAuth.getInstance().getCurrentUser();
//        if (user != null) {
//            Intent intent = new Intent(Login.this, CreateEvent.class);
//            startActivity(intent);
//        } else {

            btnlogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String email = etEmail.getText().toString();
                    final String pass = etPass.getText().toString();
                    if (email.isEmpty()) {
                        etEmail.setError(getText(R.string.ErrorLog));
                    } else if (pass.isEmpty()) {
                        etPass.setError(getText(R.string.ErrorLog2));
                    }else{
                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                user = firebaseAuth.getCurrentUser();
                                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent intent1 = new Intent(Login.this, CreateEvent.class);
                                startActivity(intent1);
                            } else {
                                errortxt.setText("Login Failed");
                                errortxt.setVisibility(View.VISIBLE);

                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            errortxt.setText("Incorrect Email/ Password");
                            errortxt.setVisibility(View.VISIBLE);
                        }
                    });}

                }
            });

    }

    public void signUp(View view) {
        Intent intent2 = new Intent(Login.this, Signup.class);
        startActivity(intent2);
    }
}