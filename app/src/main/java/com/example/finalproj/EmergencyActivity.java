package com.example.finalproj;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class EmergencyActivity extends AppCompatActivity {

    private ListView emergencyListView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);

        // Initialize views
        emergencyListView = findViewById(R.id.emergencyListView);

        // Set emergency contacts
        String[] emergencyContacts = {
                "Police of the unversity : 123",
                "Fire Department : 911",
                "University guard : 0598361134",
                "Emergency Contact 4: 0598361137",
                "Emergency Contact 5: 0598361139",
                "Emergency Contact 6: 0598361714",
                "Emergency Contact 7: 0598361132"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, emergencyContacts);
        emergencyListView.setAdapter(adapter);

        emergencyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                String[] parts = selectedItem.split(": ");
                String phoneNumber = parts[1].trim();

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            }
        });


    }
}


