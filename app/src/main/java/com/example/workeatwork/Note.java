package com.example.workeatwork;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Note extends AppCompatActivity {


    private EditText editText;
    private Button saveButton;
    private Button deleteButton;

    private DatabaseReference notesRef;

    public Note() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        editText = findViewById(R.id.editText);
        saveButton = findViewById(R.id.saveButton);
        deleteButton = findViewById(R.id.deleteButton);

        notesRef = FirebaseDatabase.getInstance().getReference().child("notes");

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                saveText(text);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }

    private void saveText(String text) {
        String noteId = notesRef.push().getKey();
        Map<String, Object> noteData = new HashMap<>();
        noteData.put("noteId", noteId);
        noteData.put("text", text);
        notesRef.child(noteId).setValue(noteData);
        Toast.makeText(this, "Text saved: " + text, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent();
        intent.putExtra("noteText", text);
        intent.putExtra("notePosition", getIntent().getIntExtra("notePosition", -1));
        setResult(RESULT_OK, intent);
        finish();
    }
}