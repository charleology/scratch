package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LaodingScreenExtra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laoding_screen_extra);
        getSupportActionBar().hide();
    }
}