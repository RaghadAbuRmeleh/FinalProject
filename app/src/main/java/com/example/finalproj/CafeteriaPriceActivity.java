package com.example.finalproj;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CafeteriaPriceActivity extends AppCompatActivity {

    private Spinner cafeteriaSpinner;
    private ListView foodListView;
    private DatabaseReference databaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria_price);

        // Initialize Firebase Database
        databaseRef = FirebaseDatabase.getInstance().getReference();

        // Initialize views
        cafeteriaSpinner = findViewById(R.id.cafeteriaSpinner);
        foodListView = findViewById(R.id.foodListView);

        // Load cafeteria names into the spinner
        loadCafeteriaNames();
    }

    private void loadCafeteriaNames() {
        DatabaseReference cafeteriasRef = databaseRef.child("cafeterias");
        cafeteriasRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> cafeteriaNames = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    cafeteriaNames.add(snapshot.getKey()); // Assuming the key is the name
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(CafeteriaPriceActivity.this,
                        android.R.layout.simple_spinner_item, cafeteriaNames);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                cafeteriaSpinner.setAdapter(adapter);

                // Set listener for spinner item selection
                cafeteriaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        loadFoodItems(cafeteriaNames.get(position));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Handle the case where no cafeteria selection is made if necessary
                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadCafeteriaNames:onCancelled", databaseError.toException());
            }
        });
    }

    private void loadFoodItems(String cafeteriaName) {
        DatabaseReference foodItemsRef = databaseRef.child("cafeterias").child(cafeteriaName).child("foodItems");
        foodItemsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> foodItems = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String itemName = snapshot.child("name").getValue(String.class);
                    String itemPrice = snapshot.child("price").getValue(String.class);
                    foodItems.add(itemName + " - " + itemPrice);
                }
                ArrayAdapter<String> foodItemsAdapter = new ArrayAdapter<>(CafeteriaPriceActivity.this,
                        android.R.layout.simple_list_item_1, foodItems);
                foodListView.setAdapter(foodItemsAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadFoodItems:onCancelled", databaseError.toException());
            }
        });
    }
}
