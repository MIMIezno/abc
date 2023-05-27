package com.example.workeatwork;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Goal extends AppCompatActivity {
    private TextView additionalInfoTextView;
    private NumberPicker minutesPicker;
    private NumberPicker secondsPicker;
    private Button startButton;
    private Button stopButton;

    private CountDownTimer timer;
    private long totalTimeInMillis;
    private boolean isTimerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        additionalInfoTextView = findViewById(R.id.additionalInfoTextView);
        minutesPicker = findViewById(R.id.minutesPicker);
        secondsPicker = findViewById(R.id.secondsPicker);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        minutesPicker.setMinValue(0);
        minutesPicker.setMaxValue(59);
        secondsPicker.setMinValue(0);
        secondsPicker.setMaxValue(59);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTimerRunning) {
                    int minutes = minutesPicker.getValue();
                    int seconds = secondsPicker.getValue();
                    totalTimeInMillis = (minutes * 60 + seconds) * 1000;

                    startTimer(totalTimeInMillis);
                    isTimerRunning = true;
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTimerRunning) {
                    stopTimer();
                }
            }
        });
    }

    private void startTimer(long milliseconds) {
        timer = new CountDownTimer(milliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimerText(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                updateTimerText(0);
                isTimerRunning = false;
                stopButton.setEnabled(false);
            }
        };

        timer.start();
        isTimerRunning = true;
        stopButton.setEnabled(true);
    }

    private void stopTimer() {
        timer.cancel();
        isTimerRunning = false;
        stopButton.setEnabled(false);
    }

    private void updateTimerText(long milliseconds) {
        int minutes = (int) (milliseconds / 1000) / 60;
        int seconds = (int) (milliseconds / 1000) % 60;

        String timeLeft = String.format("%02d:%02d", minutes, seconds);
        additionalInfoTextView.setText(timeLeft);
        additionalInfoTextView.setGravity(Gravity.CENTER);
    }


    public void openHomepage(View view) {
        Intent intent = new Intent(Goal.this, Homepage.class);
        startActivity(intent);
    }
}
