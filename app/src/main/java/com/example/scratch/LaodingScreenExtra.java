package com.example.scratch;

import static com.example.scratch.MainActivity.setWindowFlag;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class LaodingScreenExtra extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laoding_screen_extra);
        getSupportActionBar().hide();

    }
}