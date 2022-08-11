package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HorizontalProgressScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_progress_screen);
        getSupportActionBar().hide();
    }
}