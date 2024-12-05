package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize the database helper
        dbHelper = new DatabaseHelper(this);

        // Get references to UI elements
        EditText emailInput = findViewById(R.id.email_input);
        EditText passwordInput = findViewById(R.id.password_input);
        Button loginButton = findViewById(R.id.login_button);
        Button signupButton = findViewById(R.id.signup_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        // Handle login button click
        loginButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();

            // Check user credentials
            Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                    "SELECT * FROM users WHERE email = ? AND password = ?",
                    new String[]{email, password}
            );

            if (cursor.moveToFirst()) {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
                // Navigate to the homepage
                Intent intent = new Intent(SecondActivity.this, HomePageActivity.class);
                intent.putExtra("email", emailInput.getText().toString());
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(this, "Invalid email or password.", Toast.LENGTH_SHORT).show();
            }
            cursor.close();
        });
    }
}
