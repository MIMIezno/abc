package com.example.workeatwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Calendar extends AppCompatActivity {

    CalendarView calendarView;
    EditText textEdit;

    Button btnEventSave;

    DatabaseReference databaseReference;
    private String stringDateSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = findViewById(R.id.calendarView);
        textEdit = findViewById(R.id.textEdit);
        btnEventSave = findViewById(R.id.btnEventSave);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                stringDateSelected = Integer.toString(i) + Integer.toString(i1 + 1) + Integer.toString(i2); // Update the instance variable
                calendarClicked(); // Call the calendarClicked method
            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("Calendar");

        btnEventSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEvent();
            }
        });
    }

    private void calendarClicked() {
        if (stringDateSelected != null) {
            DatabaseReference childReference = databaseReference.child(stringDateSelected); // Get the child reference
            childReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.getValue() != null) {
                        textEdit.setText(snapshot.getValue().toString());
                    } else {
                        textEdit.setText("");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle onCancelled if needed
                }
            });
        }
    }

    private void saveEvent() {
        String eventText = textEdit.getText().toString();
        if (!eventText.isEmpty() && stringDateSelected != null) {
            databaseReference.child(stringDateSelected).setValue(eventText); // Save the event to the selected date
            Toast.makeText(this, "Event saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter an event text", Toast.LENGTH_SHORT).show();
        }
    }

    public void openHomepage(View view) {
        Intent intent = new Intent(Calendar.this, Homepage.class);
        startActivity(intent);
    }
}
