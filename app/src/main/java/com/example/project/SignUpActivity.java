package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize the database helper
        dbHelper = new DatabaseHelper(this);

        // Get references to UI elements
        EditText firstNameInput = findViewById(R.id.first_name_input);
        EditText lastNameInput = findViewById(R.id.last_name_input);
        EditText emailInput = findViewById(R.id.email_input);
        EditText passwordInput = findViewById(R.id.password_input);
        Button signUpButton = findViewById(R.id.signup_button);

        // Handle sign-up button click
        signUpButton.setOnClickListener(v -> {
            String firstName = firstNameInput.getText().toString();
            String lastName = lastNameInput.getText().toString();
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            // Validate inputs
            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Insert user into database
            long result = dbHelper.addUser(email, password, firstName, lastName, null, null, 0, null);

            if (result > 0) {
                Toast.makeText(this, "Sign-up successful!", Toast.LENGTH_SHORT).show();
                // Navigate to the login activity
                Intent intent = new Intent(SignUpActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Error occurred during sign-up.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
