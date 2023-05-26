package com.example.workeatwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class  Continue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
    }

    public void openOnboarding2(View view) {
        Intent intent = new Intent(Continue.this, Onboarding2.class);
        startActivity(intent);
    }

}


