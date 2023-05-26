package com.example.workeatwork;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Food extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);

        ImageView bookmarkButton = findViewById(R.id.bookmarkButton1);
        bookmarkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event for the bookmark button
                ImageButton clickedButton = (ImageButton) view;
                clickedButton.setColorFilter(Color.YELLOW);
            }
        });
    }
}
