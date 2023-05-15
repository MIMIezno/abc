package com.example.workeatwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class More extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
    }

    public void openAccount(View view) {
        Intent intent = new Intent(More.this, Account.class);
        startActivity(intent);
    }

    public void openRecipes(View view) {
        Intent intent = new Intent(More.this, Recipes.class);
        startActivity(intent);
    }

    public void openHistory(View view) {
        Intent intent = new Intent(More.this, History.class);
        startActivity(intent);
    }

    public void openReminder(View view) {
        Intent intent = new Intent(More.this, Reminder.class);
        startActivity(intent);
    }

    public void openWorkout(View view) {
        Intent intent = new Intent(More.this, Workout.class);
        startActivity(intent);
    }

    public void openSettings(View view) {
        Intent intent = new Intent(More.this, Settings.class);
        startActivity(intent);
    }

    public void openLogin(View view) {
        Intent intent = new Intent(More.this, Login.class);
        startActivity(intent);
    }
}