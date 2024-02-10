package com.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ImageView within the onCreate method
        ImageView reminderIcon = findViewById(R.id.reminderIcon);
        ImageView ambulanceIcon = findViewById(R.id.ambulanceIcon);
        ImageView mapIcan = findViewById(R.id.mapIcon);
        ImageView notesIcon = findViewById(R.id.notesIcon);
        ImageView canteenIcon = findViewById(R.id.canteenIcon);
        ImageView depIcon = findViewById(R.id.depIcon);

        // Set the OnClickListener within the onCreate method
        reminderIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the ReminderMainActivity
                Intent intent = new Intent(MainActivity.this, ReminderMainActivity.class);
                startActivity(intent);
            }
        });

        ambulanceIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the ReminderMainActivity
                Intent intent = new Intent(MainActivity.this, EmergencyActivity.class);
                startActivity(intent);
            }
        });

        mapIcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the ReminderMainActivity
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        canteenIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the ReminderMainActivity
                Intent intent = new Intent(MainActivity.this, CafeteriaPriceActivity.class);
                startActivity(intent);
            }
        });

        depIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the ReminderMainActivity
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                startActivity(intent);
            }
        });

        notesIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the ReminderMainActivity
                Intent intent = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intent);
            }
        });
    }
}
