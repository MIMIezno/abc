package com.example.workeatwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    TextView textView = findViewById(R.id.textView);
    String text = "1,200\n";
    SpannableString spannableString = new SpannableString(text);
    spannableString.setSpan(new AbsoluteSizeSpan(24, true), 0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    textView.setText(spannableString);
}