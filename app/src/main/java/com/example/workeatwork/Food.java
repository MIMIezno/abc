package com.example.workeatwork;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Food extends AppCompatActivity {
    private boolean isBookmarked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ImageView bookmarkButton = findViewById(R.id.bookmarkButton1);
        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event for the bookmark button
                ImageView clickedButton = (ImageView) v;
                if (isBookmarked) {
                    clickedButton.setColorFilter(null); // Reset to original color
                    isBookmarked = false;
                    removeFoodFromHistory(); // Remove food from history
                    Toast.makeText(Food.this, "Food removed from history", Toast.LENGTH_SHORT).show();
                } else {
                    clickedButton.setColorFilter(Color.rgb(93, 6, 156)); // Set to violet color
                    isBookmarked = true;
                    saveFoodToHistory(); // Save food in history
                    Toast.makeText(Food.this, "Food bookmarked and saved in history", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void saveFoodToHistory() {
        // Get the current time and date
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        // Combine the time and date into a single string
        String timestamp = currentTime + ", " + currentDate;

        // Implement your logic to save the bookmarked food in history here
        // For example, you can store the food details along with the timestamp in a local database or shared preferences
    }

    private void removeFoodFromHistory() {
        // Implement your logic to remove the food from history here
        // For example, you can delete the food details from the local database or remove it from shared preferences
    }
}
