package com.example.admin.tourmatemodule1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signup extends AppCompatActivity {

    EditText etName,etEmailAdd,etPhone,etPassword,etpassword2;
    Button btnRegister;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        etName=(EditText)findViewById(R.id.etNmae);
        etEmailAdd=(EditText)findViewById(R.id.etEmail);
        etPhone=(EditText)findViewById(R.id.etPhone);
        etPassword=(EditText)findViewById(R.id.etPassword);
        etpassword2=(EditText)findViewById(R.id.etPassword2);
        btnRegister=(Button)findViewById(R.id.btnSignUp);

        firebaseAuth = FirebaseAuth.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

//        if (user != null) {
//            Intent intent = new Intent(Signup.this, CreateEvent.class);
//            startActivity(intent);
//        } else {
            btnRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String emails = etEmailAdd.getText().toString();
                    String passwords = etPassword.getText().toString();
                    String password2 = etpassword2.getText().toString();
                    String name = etName.getText().toString();
                    String phone = etPhone.getText().toString();

                    if (name.isEmpty()) {
                        etName.setError(getText(R.string.error_common));
                    } else if (emails.isEmpty()) {
                        etEmailAdd.setError(getText(R.string.error_common));
                    } else if (phone.isEmpty()) {
                        etPhone.setError(getText(R.string.error_common));
                    } else if (passwords.isEmpty() || passwords.length() < 6)
                    {
                        etPassword.setError(getText(R.string.error_common2));
                    } else if (password2.isEmpty()) {
                        etpassword2.setError(getText(R.string.error_common));


                    } else if (password2.equals(passwords)) {
                        firebaseAuth.createUserWithEmailAndPassword(emails, passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Signup.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Signup.this, Login.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(Signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        etpassword2.setError(getText(R.string.password_mismatch));
                    }
                }
            });

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
