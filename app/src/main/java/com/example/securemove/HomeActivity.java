package com.example.securemove;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.securemove.screens.Welcome;


public class HomeActivity extends AppCompatActivity {


    private TextView tNom,tClasse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button NavigateToCryptage = findViewById(R.id.go);




        NavigateToCryptage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(HomeActivity.this, CrypEtDecrypt.class);
                startActivity(i);
                finish();

            }
        });


        Button goToCoursButton = findViewById(R.id.CoursBtn);


        goToCoursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, Cours.class);
                startActivity(intent);
            }
        });


        Button goToWelcome = findViewById(R.id.toWelcome);
        goToWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, Welcome.class);
                startActivity(i);
                finish();
            }
        });

        ActionBar actionBar = getSupportActionBar();

        // Check if ActionBar is not null (this check is generally a good practice)
        if (actionBar != null) {
            // Set the title
            actionBar.setTitle("Home ");
        }


    }
}

