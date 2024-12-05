package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ArmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm);

        // Bottom Navigation
        ImageButton homeButton = findViewById(R.id.home_button);
        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton settingsButton = findViewById(R.id.settings_button);

        homeButton.setOnClickListener(v -> startActivity(new Intent(this, HomePageActivity.class)));
        profileButton.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        settingsButton.setOnClickListener(v -> startActivity(new Intent(this, SettingsActivity.class)));

        // Section Buttons
        Button upperButton = findViewById(R.id.biceps_button);
        Button middleButton = findViewById(R.id.triceps_button);
        Button lowerButton = findViewById(R.id.forearm_button);

        upperButton.setOnClickListener(v -> startActivity(new Intent(this, BicepsActivity.class)));
        middleButton.setOnClickListener(v -> startActivity(new Intent(this, TricepsActivity.class)));
        lowerButton.setOnClickListener(v -> startActivity(new Intent(this, ForeArmActivity.class)));
    }
}
