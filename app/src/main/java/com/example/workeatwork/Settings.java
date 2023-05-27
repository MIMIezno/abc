package com.example.workeatwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    private PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void openMore(View view) {
        Intent intent = new Intent(Settings.this, More.class);
        startActivity(intent);
    }

    public void showAppPreferencesText(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

        // Customize the popup layout as per your requirements
        TextView popupText = popupView.findViewById(R.id.popup_text);
        popupText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consectetur magna in metus mollis facilisis. Duis tempus pulvinar nibh non feugiat. Maecenas nec ultrices justo. Vivamus mi lectus, blandit eu luctus quis, gravida eget dolor. Suspendisse eu malesuada nisi. Maecenas vulputate ligula eget nisl porttitor efficitur vitae nec ex. Pellentesque at diam consequat, ultrices nibh in, molestie lectus. Vestibulum a diam ac magna dictum mattis ut et dolor. Duis ultrices, metus quis scelerisque posuere, erat sapien ultricies nisl, ac dictum sapien dolor vel nunc. Pellentesque lobortis mauris ac velit luctus faucibus id vitae risus. Nam euismod vehicula diam ut condimentum. Sed fringilla ac mi quis condimentum. Fusce in nulla mauris.");

        // Set text justification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            popupText.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        // Create the popup window
        int width = 800;
        int height = 1200;
        popupWindow = new PopupWindow(popupView, width, height, true);

        // Set the window to appear in the center
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    public void showHelpText(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

        // Customize the popup layout as per your requirements
        TextView popupText = popupView.findViewById(R.id.popup_text);
        popupText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consectetur magna in metus mollis facilisis. Duis tempus pulvinar nibh non feugiat. Maecenas nec ultrices justo. Vivamus mi lectus, blandit eu luctus quis, gravida eget dolor. Suspendisse eu malesuada nisi. Maecenas vulputate ligula eget nisl porttitor efficitur vitae nec ex. Pellentesque at diam consequat, ultrices nibh in, molestie lectus. Vestibulum a diam ac magna dictum mattis ut et dolor. Duis ultrices, metus quis scelerisque posuere, erat sapien ultricies nisl, ac dictum sapien dolor vel nunc. Pellentesque lobortis mauris ac velit luctus faucibus id vitae risus. Nam euismod vehicula diam ut condimentum. Sed fringilla ac mi quis condimentum. Fusce in nulla mauris.");

        // Set text justification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            popupText.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        // Create the popup window
        int width = 800;
        int height = 1200;
        popupWindow = new PopupWindow(popupView, width, height, true);

        // Set the window to appear in the center
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    public void showContactText(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

        // Customize the popup layout as per your requirements
        TextView popupText = popupView.findViewById(R.id.popup_text);
        popupText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consectetur magna in metus mollis facilisis. Duis tempus pulvinar nibh non feugiat. Maecenas nec ultrices justo. Vivamus mi lectus, blandit eu luctus quis, gravida eget dolor. Suspendisse eu malesuada nisi. Maecenas vulputate ligula eget nisl porttitor efficitur vitae nec ex. Pellentesque at diam consequat, ultrices nibh in, molestie lectus. Vestibulum a diam ac magna dictum mattis ut et dolor. Duis ultrices, metus quis scelerisque posuere, erat sapien ultricies nisl, ac dictum sapien dolor vel nunc. Pellentesque lobortis mauris ac velit luctus faucibus id vitae risus. Nam euismod vehicula diam ut condimentum. Sed fringilla ac mi quis condimentum. Fusce in nulla mauris.");

        // Set text justification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            popupText.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
        // Create the popup window
        int width = 800;
        int height = 1200;
        popupWindow = new PopupWindow(popupView, width, height, true);

        // Set the window to appear in the center
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }
    public void showJoinText(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

        // Create the popup window
        int width = 800;
        int height = 1200;
        popupWindow = new PopupWindow(popupView, width, height, true);

        // Set the window to appear in the center
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // Create a LinearLayout with vertical orientation
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        layout.setLayoutParams(layoutParams);

        // Create a TextView for the title and add it to the layout
        TextView titleTextView = new TextView(this);
        titleTextView.setText("COMMUNITY GUIDELINES");
        titleTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        titleTextView.setGravity(Gravity.CENTER);
        layout.addView(titleTextView);

        // Create a TextView for the paragraph and add it to the layout
        TextView paragraphTextView = new TextView(this);
        paragraphTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        paragraphTextView.setText("\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consectetur magna in metus mollis facilisis. Duis tempus pulvinar nibh non feugiat. Maecenas nec ultrices justo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus faucibus velit id velit consequat ultricies. Nulla lacus nunc, laoreet eget erat quis, dignissim suscipit tellus. Fusce quam velit, interdum rhoncus diam faucibus, cursus mollis est. Aliquam erat volutpat. Donec imperdiet volutpat ante, quis pulvinar nisl ornare eget. Duis vel convallis lorem, sed porta metus. Aenean ac tempus magna, et ultrices nunc. Ut ullamcorper nisi a condimentum lacinia. Vestibulum dignissim vitae est in feugiat. Praesent facilisis pulvinar neque vel faucibus. Sed lacinia risus nec dolor tincidunt condimentum. Cras faucibus varius augue id varius. Morbi facilisis in tellus ac gravida.\n");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            paragraphTextView.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD); // Justify-align the text
        }
        layout.addView(paragraphTextView);

        // Create a Button and add it to the layout
        Button joinButton = new Button(this);
        joinButton.setText("Join Now!");
        joinButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        layout.addView(joinButton);

        // Add the layout to the popup layout
        ((LinearLayout) popupView).addView(layout);

        // Set onClickListener for the join button
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Settings.this, "Welcome to Work Eat Work!", Toast.LENGTH_SHORT).show();
                popupWindow.dismiss();
            }
        });
    }





    public void showRateText(View view) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView = inflater.inflate(R.layout.popup_layout, null);

            // Create the popup window
            int width = 800;
            int height = 1200;
            popupWindow = new PopupWindow(popupView, width, height, true);

            // Set the window to appear in the center
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

            // Create a LinearLayout with vertical orientation
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            layoutParams.gravity = Gravity.CENTER;
            layout.setLayoutParams(layoutParams);

            // Create a TextView for the title and add it to the layout
            TextView titleTextView = new TextView(this);
            titleTextView.setText("Please rate us.");
            titleTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            titleTextView.setGravity(Gravity.CENTER);
            layout.addView(titleTextView);

            // Create a RatingBar and add it to the layout
            RatingBar ratingBar = new RatingBar(this);
            ratingBar.setNumStars(5);
            ratingBar.setStepSize(1.0f);
            ratingBar.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            layout.addView(ratingBar);

            // Create a Button and add it to the layout
            Button submitButton = new Button(this);
            submitButton.setText("Submit");
            submitButton.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            layout.addView(submitButton);

            // Add the layout to the popup layout
            ((LinearLayout) popupView).addView(layout);

            // Set onClickListener for the submit button
            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    float rating = ratingBar.getRating();
                    // Show gratitude message based on the rating
                    if (rating >= 4.0) {
                        Toast.makeText(Settings.this, "Thank you for your rating! We're glad you liked it.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Settings.this, "Thank you for your rating! We appreciate your feedback.", Toast.LENGTH_SHORT).show();
                    }
                    popupWindow.dismiss();
                }
            });
        }

    public void showTermsText(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

        // Create the popup window
        int width = 800;
        int height = 1200;
        popupWindow = new PopupWindow(popupView, width, height, true);

        // Set the window to appear in the center
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // Create a LinearLayout with vertical orientation
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
        layout.setLayoutParams(layoutParams);

        // Create a TextView for the title and add it to the layout
        TextView titleTextView = new TextView(this);
        titleTextView.setText("TERMS and CONDITIONS");
        titleTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        titleTextView.setGravity(Gravity.CENTER);
        layout.addView(titleTextView);

        // Create a TextView for the paragraph and add it to the layout
        TextView paragraphTextView = new TextView(this);
        paragraphTextView.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        paragraphTextView.setText("\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Proin consectetur magna in metus mollis facilisis. Duis tempus pulvinar nibh non feugiat. Maecenas nec ultrices justo. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus faucibus velit id velit consequat ultricies. Nulla lacus nunc, laoreet eget erat quis, dignissim suscipit tellus. Fusce quam velit, interdum rhoncus diam faucibus, cursus mollis est. Aliquam erat volutpat. Donec imperdiet volutpat ante, quis pulvinar nisl ornare eget. Duis vel convallis lorem, sed porta metus. Aenean ac tempus magna, et ultrices nunc. Ut ullamcorper nisi a condimentum lacinia. Vestibulum dignissim vitae est in feugiat. Praesent facilisis pulvinar neque vel faucibus. Sed lacinia risus nec dolor tincidunt condimentum. Cras faucibus varius augue id varius. Morbi facilisis in tellus ac gravida.\n");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            paragraphTextView.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD); // Justify-align the text
        }
        layout.addView(paragraphTextView);

        // Create a RadioButton and add it to the layout
        RadioButton radioButton = new RadioButton(this);
        radioButton.setText("Accept");
        radioButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        layout.addView(radioButton);

        // Create a Button and add it to the layout
        Button finishButton = new Button(this);
        finishButton.setText("Finish");
        finishButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        layout.addView(finishButton);

        // Add the layout to the popup layout
        ((LinearLayout) popupView).addView(layout);

        // Set onClickListener for the finish button
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean termsAccepted = radioButton.isChecked();
                if (termsAccepted) {
                    Toast.makeText(Settings.this, "Thank you for accepting the terms and conditions.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Settings.this, "Please accept the terms.", Toast.LENGTH_SHORT).show();
                }
                popupWindow.dismiss();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Dismiss the popup window to avoid memory leaks
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }
}