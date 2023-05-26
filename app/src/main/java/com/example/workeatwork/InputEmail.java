package com.example.workeatwork;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class InputEmail extends AppCompatActivity {

    private TextInputEditText emailEditText, passwordEditTex;

    ImageView Register;

    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_email);


        emailEditText = findViewById(R.id.email);
        passwordEditTex = findViewById(R.id.password);
        Register = findViewById(R.id.Register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, password;
                email = String.valueOf(emailEditText.getText());
                password = String.valueOf(passwordEditTex.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(InputEmail.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(InputEmail.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(InputEmail.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(InputEmail.this, Login.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                        else{
                                        Toast.makeText(InputEmail.this, "It must be 8 characters", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


            }
        });


    }
}







/*
    public void openHomepage(View view) {
        Intent intent = new Intent(InputEmail.this, Homepage.class);
        startActivity(intent);
    }
}*/