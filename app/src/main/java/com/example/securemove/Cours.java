package com.example.securemove;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.securemove.adapter.MyPagerAdapter;

public class Cours extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);

        ViewPager viewPagerCours = findViewById(R.id.viewPager1);
        MyPagerAdapter adapter = new MyPagerAdapter(this);
        viewPagerCours.setAdapter(adapter);


    }
}