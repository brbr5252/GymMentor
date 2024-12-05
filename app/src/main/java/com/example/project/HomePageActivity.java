package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {
    private String loggedInEmail; // Store logged-in user's email
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Muscle Buttons
        Button chestButton = findViewById(R.id.chest_button);
        Button backButton = findViewById(R.id.back_button);
        Button armButton = findViewById(R.id.arm_button);
        Button legButton = findViewById(R.id.leg_button);
        Button shoulderButton = findViewById(R.id.shoulder_button);

        // Navigation Buttons
        ImageButton homeButton = findViewById(R.id.home_button);
        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton settingsButton = findViewById(R.id.settings_button);

        Intent ntent = getIntent();
        loggedInEmail = ntent.getStringExtra("email");
        Intent intent = new Intent(HomePageActivity.this, ProfileActivity.class);
        intent.putExtra("email", loggedInEmail);

        // Muscle Navigation
        chestButton.setOnClickListener(v -> startActivity(new Intent(this, ChestActivity.class)));
        backButton.setOnClickListener(v -> startActivity(new Intent(this, BackActivity.class)));
        armButton.setOnClickListener(v -> startActivity(new Intent(this, ArmActivity.class)));
        legButton.setOnClickListener(v -> startActivity(new Intent(this, LegActivity.class)));
        shoulderButton.setOnClickListener(v -> startActivity(new Intent(this, ShoulderActivity.class)));

        // Bottom Navigation
        // Retrieve the email of the logged-in user

        homeButton.setOnClickListener(v -> startActivity(new Intent(this, HomePageActivity.class)));
        profileButton.setOnClickListener(v -> startActivity(intent));
        settingsButton.setOnClickListener(v -> startActivity(new Intent(this, SettingsActivity.class)));
    }
}
