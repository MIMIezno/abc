package com.example.workeatwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Front extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
    }
//open register
    public void openActivity(View view) {
        Intent intent = new Intent(Front.this, Register.class);
        startActivity(intent);
    }

    public void openLogin(View view) {
        Intent intent = new Intent(Front.this, Login.class);
        startActivity(intent);
    }
}