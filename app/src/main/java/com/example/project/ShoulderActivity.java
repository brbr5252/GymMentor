package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ShoulderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder);

        // Bottom Navigation
        ImageButton homeButton = findViewById(R.id.home_button);
        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton settingsButton = findViewById(R.id.settings_button);

        homeButton.setOnClickListener(v -> startActivity(new Intent(this, HomePageActivity.class)));
        profileButton.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        settingsButton.setOnClickListener(v -> startActivity(new Intent(this, SettingsActivity.class)));

        // Section Buttons
        Button upperButton = findViewById(R.id.front_shoulder_button);
        Button middleButton = findViewById(R.id.side_button);
        Button lowerButton = findViewById(R.id.back_shoulder_button);

        upperButton.setOnClickListener(v -> startActivity(new Intent(this, FrontShoulderActivity.class)));
        middleButton.setOnClickListener(v -> startActivity(new Intent(this, SideShoulderActivity.class)));
        lowerButton.setOnClickListener(v -> startActivity(new Intent(this, BackShoulderActivity.class)));
    }
}
