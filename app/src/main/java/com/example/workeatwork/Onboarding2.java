package com.example.workeatwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Onboarding2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding2);
    }

    public void openOnboarding3(View view) {
        Intent intent = new Intent(Onboarding2.this, Onboarding3.class);
        startActivity(intent);
    }

}