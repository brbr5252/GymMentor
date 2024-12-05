package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private String loggedInEmail; // Store logged-in user's email

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Retrieve the email of the logged-in user
        Intent intent = getIntent();
        loggedInEmail = intent.getStringExtra("email");

        // Get references to UI elements
        TextView welcomeText = findViewById(R.id.welcome);
        EditText weightInput = findViewById(R.id.weight_input);
        EditText heightInput = findViewById(R.id.height_input);
        EditText ageInput = findViewById(R.id.age_input);
        EditText genderInput = findViewById(R.id.gender_input);
        Button saveButton = findViewById(R.id.save);
        Button logOutButton = findViewById(R.id.logout_button);
        ImageButton homeButton = findViewById(R.id.home_button);
        ImageButton profileButton = findViewById(R.id.profile_button);
        ImageButton settingsButton = findViewById(R.id.settings_button);

        // Retrieve and display user data
        Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                "SELECT * FROM users WHERE email = ?", new String[]{loggedInEmail});

        if (cursor.moveToFirst()) {
            String firstName = cursor.getString(cursor.getColumnIndexOrThrow("first_name"));
            welcomeText.setText("Welcome " + firstName);

            weightInput.setText(cursor.getString(cursor.getColumnIndexOrThrow("weight")));
            heightInput.setText(cursor.getString(cursor.getColumnIndexOrThrow("height")));
            ageInput.setText(String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("age"))));
            genderInput.setText(cursor.getString(cursor.getColumnIndexOrThrow("gender")));
        }
        cursor.close();

        // Handle Save button click
        saveButton.setOnClickListener(v -> {
            String weight = weightInput.getText().toString();
            String height = heightInput.getText().toString();
            int age;
            try {
                age = Integer.parseInt(ageInput.getText().toString());
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Please enter a valid age", Toast.LENGTH_SHORT).show();
                return;
            }
            String gender = genderInput.getText().toString();

            // Update user data in the database
            boolean isUpdated = dbHelper.updateUserData(loggedInEmail, weight, height, age, gender);

            if (isUpdated) {
                Toast.makeText(this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error updating profile.", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle Logout button click
        logOutButton.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        // Bottom Navigation
        homeButton.setOnClickListener(v -> startActivity(new Intent(this, HomePageActivity.class)));
        profileButton.setOnClickListener(v -> startActivity(new Intent(this, ProfileActivity.class)));
        settingsButton.setOnClickListener(v -> startActivity(new Intent(this, SettingsActivity.class)));
    }
}
