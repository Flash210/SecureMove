package com.example.securemove.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.securemove.R;

public class Welcome extends AppCompatActivity {
    private TextView textViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        textViewData = findViewById(R.id.textViewData);
        TextView logoutButton = findViewById(R.id.logoutButton);

        // Retrieve data from SharedPreferences
        String data1 = getData("data1");
        String data2 = getData("data2");

        // Display data in TextView
        textViewData.setText("Nom : " + data1 + "\nClasse : " + data2);
        //c.setText(data2);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logout: Clear SharedPreferences and go back to MainActivity
                clearSharedPreferences();
                Toast.makeText(Welcome.this, "Logout Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Welcome.this, Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private String getData(String key) {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    private void clearSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}