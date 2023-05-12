package com.example.workeatwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InputEmail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_email);
    }

    public void openHomepage(View view) {
        Intent intent = new Intent(InputEmail.this, Homepage.class);
        startActivity(intent);
    }
}