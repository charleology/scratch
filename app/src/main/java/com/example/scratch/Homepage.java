package com.example.scratch;

import static com.example.scratch.Header.gotoMessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Homepage extends AppCompatActivity {

    TextView headerTitle;
    ImageView filterImgview, menuImgview, messageImgview;
    Button applyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().hide();

        View view = findViewById(R.id.headerLayout);
        headerTitle = (TextView) findViewById(R.id.headerTitle);
        filterImgview = (ImageView) findViewById(R.id.filterImgview);
        menuImgview = (ImageView) findViewById(R.id.menuImgview);
        messageImgview = (ImageView) findViewById(R.id.messageImgview);

        applyBtn = (Button) findViewById(R.id.applyBtn);

        /*filterImgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoMessage(Homepage.this);
            }
        });*/

    }
}