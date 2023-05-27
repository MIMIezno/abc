package com.example.workeatwork;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Reminder extends AppCompatActivity {
    private LinearLayout containerLayout;
    private int taskCount = 1;
    private int completedTaskCount = 1; // Counter for completed tasks

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        containerLayout = findViewById(R.id.containerLayout);
        ImageView addImageView = findViewById(R.id.add);
        addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewRelativeLayout();
            }
        });
    }

    private void createNewRelativeLayout() {
        // Increment the task count
        taskCount++;

        // Update the task count TextView
        TextView taskCountTextView = findViewById(R.id.textView65);
        taskCountTextView.setText(completedTaskCount + " / " + taskCount + " tasks completed");

        RelativeLayout referenceRelativeLayout = findViewById(R.id.referenceRelativeLayout);

        // Get the width and height of the reference RelativeLayout
        int referenceWidth = referenceRelativeLayout.getWidth();
        int referenceHeight = referenceRelativeLayout.getHeight();

        RelativeLayout newRelativeLayout = new RelativeLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(referenceWidth, referenceHeight);
        layoutParams.setMargins(dpToPx(30), dpToPx(10), 0, 0);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
        newRelativeLayout.setLayoutParams(layoutParams);
        newRelativeLayout.setBackgroundResource(R.drawable.task_bg);

        CheckBox checkBox = new CheckBox(this);
        RelativeLayout.LayoutParams checkBoxParams = new RelativeLayout.LayoutParams(
                dpToPx(150),
                dpToPx(58)
        );
        checkBoxParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        checkBoxParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        checkBoxParams.setMargins(dpToPx(20), dpToPx(8), 0, 0);
        checkBox.setLayoutParams(checkBoxParams);
        checkBox.setButtonDrawable(R.drawable.custom_checkbox);
        checkBox.setButtonTintList(ColorStateList.valueOf(Color.BLACK));
        checkBox.setPadding(dpToPx(10), dpToPx(10), dpToPx(10), dpToPx(10));
        checkBox.setText("New Task");

        // Add the OnCheckedChangeListener to the CheckBox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Update the completed task count based on the checked state
                if (isChecked) {
                    completedTaskCount++;
                } else {
                    completedTaskCount--;
                }
                // Update the task count TextView with the completed task count
                taskCountTextView.setText(completedTaskCount + " / " + taskCount + " tasks completed");
            }
        });

        ImageView editImageView = new ImageView(this);
        RelativeLayout.LayoutParams editImageParams = new RelativeLayout.LayoutParams(
                dpToPx(25),
                dpToPx(29)
        );
        editImageParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        editImageParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        editImageParams.setMargins(0, 0, dpToPx(20), dpToPx(20));
        editImageView.setLayoutParams(editImageParams);
        editImageView.setImageResource(R.drawable.edit_document_icon);

        newRelativeLayout.addView(checkBox);
        newRelativeLayout.addView(editImageView);

        LinearLayout containerLayout = findViewById(R.id.containerLayout);
        containerLayout.addView(newRelativeLayout);
    }

    // Helper method to convert dp to pixels
    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    // Rest of your code...
}
