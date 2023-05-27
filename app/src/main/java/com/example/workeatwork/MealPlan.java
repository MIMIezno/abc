package com.example.workeatwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MealPlan extends AppCompatActivity {

    ListView recordList;
    Button addButton;

    List<String> recordsList;
    ArrayAdapter<String> recordsAdapter;
    int selectedPosition = -1;

    private static final int REQUEST_CODE_NOTE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan);

        recordList = findViewById(R.id.recordList);
        addButton = findViewById(R.id.addButton);

        recordsList = new ArrayList<>();
        recordsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recordsList);
        recordList.setAdapter(recordsAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNote();
            }
        });

     /*   openNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedPosition != -1) {
                    String selectedNote = recordsList.get(selectedPosition);
                    Intent intent = new Intent(MealPlan.this, Note.class);
                    intent.putExtra("noteText", selectedNote);
                    startActivity(intent);
                } else {
                    Toast.makeText(MealPlan.this, "Please select a note", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        recordList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedNote = recordsList.get(position);
                Intent intent = new Intent(MealPlan.this, Note.class);
                intent.putExtra("noteText", selectedNote);
                startActivityForResult(intent, REQUEST_CODE_NOTE);
            }
        });
    }

    private void openNote() {
        Intent intent = new Intent(MealPlan.this, Note.class);
        startActivityForResult(intent, REQUEST_CODE_NOTE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_NOTE && resultCode == RESULT_OK) {
            if (data != null) {
                String noteText = data.getStringExtra("noteText");
                if (noteText != null && !noteText.isEmpty()) {
                    recordsList.add(noteText);
                    recordsAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}