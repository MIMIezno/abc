package com.example.workeatwork;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    private TextInputEditText emailEditText, passwordEditTex;

    Button login;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailEditText = findViewById(R.id.email);
        passwordEditTex = findViewById(R.id.password);
        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email, password;
                email = String.valueOf(emailEditText.getText());
                password = String.valueOf(passwordEditTex.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Login.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Login.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Login.this, Homepage.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else{
                                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

     /*   emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);*/
    }
}





/*
    public void openHomepage(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Perform login validation
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
        } else if (email.equals("sample@gmail.com") && password.equals("123")) {
            // Login successful
            Intent intent = new Intent(this, Homepage.class);
            startActivity(intent);
            finish();
        } else {
            // Login failed
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}*/