package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

public class Header extends AppCompatActivity {

    static ImageView MESSAGE_IMGVIEW, FILTER_IMGVIEW, MENU_IMGVIEW;
    static TextView HEADER_TITLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        getSupportActionBar().hide();

        MESSAGE_IMGVIEW = (ImageView) findViewById(R.id.messageImgview);
        MENU_IMGVIEW = (ImageView) findViewById(R.id.menuImgview);
        FILTER_IMGVIEW = (ImageView) findViewById(R.id.filterImgview);
        HEADER_TITLE = (TextView) findViewById(R.id.headerTitle);
    }

}