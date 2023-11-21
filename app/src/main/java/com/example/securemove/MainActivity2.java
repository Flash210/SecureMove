package com.example.securemove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Button b2=findViewById(R.id.go);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(MainActivity2.this,CrypEtDecrypt.class);
                startActivity(i);
                finish();

            }
        });



        Button goToCoursButton = findViewById(R.id.CoursBtn);


        goToCoursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an intent to open the Cours activity
                Intent intent = new Intent(MainActivity2.this, Cours.class);

                // Add any additional information to the intent if needed

                // Start the Cours activity
                startActivity(intent);
            }
        });
    }


}