package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        // Bottom Navigation
        ImageButton homeButton = findViewById(R.id.home_button);
        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton settingsButton = findViewById(R.id.settings_button);

        homeButton.setOnClickListener(v -> startActivity(new Intent(this, HomePageActivity.class)));
        profileButton.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        settingsButton.setOnClickListener(v -> startActivity(new Intent(this, SettingsActivity.class)));

        // Section Buttons
        Button upperButton = findViewById(R.id.back_upper_button);
        Button middleButton = findViewById(R.id.lats_button);
        Button lowerButton = findViewById(R.id.back_lower_button);

        upperButton.setOnClickListener(v -> startActivity(new Intent(this, UpperBackActivity.class)));
        middleButton.setOnClickListener(v -> startActivity(new Intent(this, LatsBackActivity.class)));
        lowerButton.setOnClickListener(v -> startActivity(new Intent(this, LowerBackActivity.class)));
    }
}
