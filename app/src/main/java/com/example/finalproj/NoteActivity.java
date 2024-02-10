package com.example.finalproj;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        final EditText titleInput = findViewById(R.id.noteTitle);
        final EditText contentInput = findViewById(R.id.noteContent);
        Button saveButton = findViewById(R.id.saveNoteButton);

        saveButton.setOnClickListener(view -> {
            String title = titleInput.getText().toString();
            String content = contentInput.getText().toString();
            List<Note> notes = NoteUtils.loadNotes(NoteActivity.this);
            notes.add(new Note(title, content));
            NoteUtils.saveNotes(NoteActivity.this, notes);
            setResult(RESULT_OK, new Intent());
            finish();
        });
    }
}
