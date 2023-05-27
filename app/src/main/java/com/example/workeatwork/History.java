package com.example.workeatwork;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class History extends AppCompatActivity {

    private LinearLayout historyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyLayout = findViewById(R.id.historyLayout);

        // Fetch the bookmarked food items from your storage
        ArrayList<String> bookmarkedFoods = fetchBookmarkedFoods();

        // Display the bookmarked food items in the layout
        displayBookmarkedFoods(bookmarkedFoods);
    }

    private ArrayList<String> fetchBookmarkedFoods() {
        // Implement your logic to fetch the bookmarked food items from your storage
        // For example, retrieve the food items from a local database or shared preferences
        ArrayList<String> bookmarkedFoods = new ArrayList<>();
        bookmarkedFoods.add("COCO BANANA PROTEIN SMOOTHIE");
        bookmarkedFoods.add("Another Bookmarked Food");
        return bookmarkedFoods;
    }

    private void displayBookmarkedFoods(ArrayList<String> bookmarkedFoods) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm | yyyy-MM-dd", Locale.getDefault());
        String currentTimeAndDate = dateFormat.format(new Date());

        // Create a TextView for the time and date
        TextView timeTextView = new TextView(this);
        timeTextView.setText(currentTimeAndDate);
        historyLayout.addView(timeTextView);

        for (String food : bookmarkedFoods) {
            String bookmarkedFoodWithTime = food;

            // Create a TextView for the food item
            TextView foodTextView = new TextView(this);
            foodTextView.setText(bookmarkedFoodWithTime);
            historyLayout.addView(foodTextView);
        }
    }
}
