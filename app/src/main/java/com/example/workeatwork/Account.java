package com.example.workeatwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void openLogin(View view) {
        Intent intent = new Intent(Account.this, Login.class);
        startActivity(intent);
    }

    public void openHomepage(View view) {
        Intent intent = new Intent(Account.this, Homepage.class);
        startActivity(intent);
    }
}