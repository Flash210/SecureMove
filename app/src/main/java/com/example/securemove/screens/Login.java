package com.example.securemove.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.securemove.HomeActivity;
import com.example.securemove.OnBordingScreen;
import com.example.securemove.R;

public class Login extends AppCompatActivity {
    private EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data1 = editText1.getText().toString();
                String data2 = editText2.getText().toString();

                // Save the data to SharedPreferences
                saveData(data1, data2);
                Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();

                // Start SecondActivity
                Intent intent = new Intent(Login.this, OnBordingScreen.class);
                startActivity(intent);
                finish();
            }
        });

        // Check if the user is already logged in
        if (isLoggedIn()) {
            // Start SecondActivity directly
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }

    private void saveData(String data1, String data2) {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("data1", data1);
        editor.putString("data2", data2);
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    private boolean isLoggedIn() {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return preferences.getBoolean("isLoggedIn", false);
    }
}