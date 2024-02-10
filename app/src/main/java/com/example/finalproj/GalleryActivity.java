package com.example.finalproj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private Button nextButton;
    private List<ViewPagerItem> itemList = new ArrayList<>();
    private int currentItemIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        viewPager = findViewById(R.id.viewpager);
        nextButton = findViewById(R.id.button);

        List<ViewPagerItem> itemList = new ArrayList<>();
        itemList.add(new ViewPagerItem(R.drawable.bzueco, "bzu", "fdajfnl djwolaijdqw qwdjdjil"));
        itemList.add(new ViewPagerItem(R.drawable.bzukam, "bzu", "fdsvfargvrdgvr"));
        itemList.add(new ViewPagerItem(R.drawable.bzueco, "bzu", "grgwresgef fvfwe gidqiwuheruifufuhrfer,  g rgg fhi  ih"));
        itemList.add(new ViewPagerItem(R.drawable.bzukam, "bzu", "ndsla  dina ldnfcho eonf fiea"));
        itemList.add(new ViewPagerItem(R.drawable.bzueco, "bzu", "m jpdv jds f vi"));

        viewPager.setAdapter(new MyGalleryAdapter(itemList));

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentItemIndex = (currentItemIndex + 1) % itemList.size();
                viewPager.setCurrentItem(currentItemIndex, true);
            }
        });
    }
}

