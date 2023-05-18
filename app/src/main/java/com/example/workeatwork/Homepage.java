package com.example.workeatwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void openBlog(View view) {
        Intent intent = new Intent(Homepage.this, Blog.class);
        startActivity(intent);
    }

    public void openMore(View view) {
        Intent intent = new Intent(Homepage.this, More.class);
        startActivity(intent);
    }

    public void openReminder(View view) {
        Intent intent = new Intent(Homepage.this, Reminder.class);
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

}