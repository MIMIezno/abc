package com.example.workeatwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
    }

    public void openHomepage(View view) {
        Intent intent = new Intent(History.this, Homepage.class);
        startActivity(intent);
    }
}