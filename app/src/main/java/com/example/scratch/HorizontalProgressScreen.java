package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HorizontalProgressScreen extends AppCompatActivity {

    TextView horizontalProgressTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_progress_screen);
        getSupportActionBar().hide();

        horizontalProgressTv = (TextView) findViewById(R.id.horizontalProgressTv);
    }
}