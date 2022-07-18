package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Homepage extends AppCompatActivity {

    TextView HEADER_TITLE;
    ImageView FILTER_IMGVIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().hide();

        HEADER_TITLE = (TextView) findViewById(R.id.headerTitle);
        FILTER_IMGVIEW = (ImageView) findViewById(R.id.filterImgview);

        View view = findViewById(R.id.headerLayout);

    }
}