package com.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity {

    private List<Note> notesList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private List<String> notesTitleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ListView notesListView = findViewById(R.id.notesListView);
        Button addNoteButton = findViewById(R.id.addNoteButton);

        notesList = NoteUtils.loadNotes(this);
        for (Note note : notesList) {
            notesTitleList.add(note.getTitle());
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesTitleList);
        notesListView.setAdapter(adapter);

        addNoteButton.setOnClickListener(view -> {
            Intent intent = new Intent(NotesActivity.this, NoteActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            notesList = NoteUtils.loadNotes(this);
            notesTitleList.clear();
            for (Note note : notesList) {
                notesTitleList.add(note.getTitle());
            }
            adapter.notifyDataSetChanged();
        }
    }
}
