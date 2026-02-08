package com.example.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AboutActivity extends AppCompatActivity {

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();

        String username = intent.getStringExtra("user");
        int age = intent.getIntExtra("age", 0);
        Boolean isPremium = intent.getBooleanExtra("isPremium", false);
        String message = intent.getStringExtra("message");



        resultText = findViewById(R.id.resultText);
        resultText.setText(String.format("Name: %s\nAge: %s\nIs Premium: %b\nMessage: %s", username, age, isPremium ? "Yes" : "No", message));
    }
}