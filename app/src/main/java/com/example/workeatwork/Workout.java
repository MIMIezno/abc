package com.example.workeatwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Workout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
    }
    public void openLegsVideo(View view) {
        // Replace "VIDEO_URL" with the actual URL of your YouTube video
        String videoUrl = "https://www.youtube.com/watch?v=IUWJ08wPykU";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
        startActivity(intent);
    }

    public void openBackVideo(View view) {
        // Replace "VIDEO_URL" with the actual URL of your YouTube video
        String videoUrl = "https://www.youtube.com/watch?v=Mu4h_8SzIN4";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
        startActivity(intent);
    }

    public void openArmsVideo(View view) {
        // Replace "VIDEO_URL" with the actual URL of your YouTube video
        String videoUrl = "https://www.youtube.com/watch?v=8IiAszxT3WA";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
        startActivity(intent);
    }

    public void openCoreVideo(View view) {
        // Replace "VIDEO_URL" with the actual URL of your YouTube video
        String videoUrl = "https://www.youtube.com/watch?v=A1vB0Zw2YGM";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl));
        startActivity(intent);
    }
}