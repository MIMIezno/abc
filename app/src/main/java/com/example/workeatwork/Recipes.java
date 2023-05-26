package com.example.workeatwork;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Recipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
    }

    public void openSaveFood(View view) {
        Intent intent = new Intent(Recipes.this, Food.class);
        startActivity(intent);
    }
}