package com.example.workeatwork;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {

    ImageView profile;
    TextView Uname;
    SharedPreferences sharedPreferences;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        profile = findViewById(R.id.profile);

        //update
        Uname = findViewById(R.id.username);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        String updatedUsername = sharedPreferences.getString("username", "");
        if (!updatedUsername.isEmpty()) {
            Uname.setText(updatedUsername);
        }


        String imageUriString = getIntent().getStringExtra("profile_image_uri");
        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            profile.setImageURI(imageUri);
        }


    }

    public void openBlog(View view) {
        Intent intent = new Intent(Homepage.this, Blog.class);
        startActivity(intent);
    }

    public void openMore(View view) {
        Intent intent = new Intent(Homepage.this, More.class);
        startActivity(intent);
    }


    public void openAccount(View view) {
        Intent intent = new Intent(Homepage.this, Account.class);
        startActivity(intent);
    }

    public void openWorkout(View view) {
        Intent intent = new Intent(Homepage.this, Workout.class);
        startActivity(intent);
    }

    public void openRecipes(View view) {
        Intent intent = new Intent(Homepage.this, Recipes.class);
        startActivity(intent);
    }

    public void openCalendar(View view) {
        Intent intent = new Intent(Homepage.this, Calendar.class);
        startActivity(intent);
    }

    public void openGoals(View view) {
        Intent intent = new Intent(Homepage.this, Goal.class);
        startActivity(intent);
    }

    public void openMealPlan(View view) {
        Intent intent = new Intent(Homepage.this, MealPlan.class);
        startActivity(intent);
    }
}