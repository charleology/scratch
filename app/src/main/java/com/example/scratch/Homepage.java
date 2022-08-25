package com.example.scratch;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.yalantis.library.Koloda;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {

    private SwipeAdapter adapter;
    private List<Integer> list;
    Koloda koloda;
    DrawerLayout drawerLayout;
    TextView headerTitle, editProfileTv;
    ImageView filterImgview, messageImgview, menuImgview, closeDrawerBtn;
    Button applyBtn, aboutOfficeBtn, aboutUsBtn, adoptionHistoryBtn;
    ImageView heartIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().hide();

        LoadingDialog loadingDialog = new LoadingDialog(Homepage.this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        View view = findViewById(R.id.headerLayout);
        headerTitle = (TextView) findViewById(R.id.headerTitle);
        filterImgview = (ImageView) findViewById(R.id.filterImgview);
        messageImgview = (ImageView) findViewById(R.id.messageImgview);
        menuImgview = (ImageView) findViewById(R.id.menuImgview);
        applyBtn = (Button) findViewById(R.id.applyBtn);
        heartIcon = (ImageView) findViewById(R.id.heartIcon);
        closeDrawerBtn = (ImageView) findViewById(R.id.closeDrawerBtn);
        aboutOfficeBtn = (Button) findViewById(R.id.aboutOfficeBtn);
        aboutUsBtn = (Button) findViewById(R.id.aboutUsBtn);
        editProfileTv = (TextView) findViewById(R.id.editProfileTv);
        adoptionHistoryBtn = (Button) findViewById(R.id.adoptionHistoryBtn);

        editProfileTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homepage.this, EditProfile.class);
                startActivity(i);
            }
        });

        menuImgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.END);
            }
        });

        closeDrawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.closeDrawer(GravityCompat.END);
            }
        });

        aboutOfficeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Homepage.this, AboutTheOffice.class);
                startActivity(i);
            }
        });

        aboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent z = new Intent(Homepage.this, AboutUs.class);
                startActivity(z);
            }
        });

        //Koloda swipe
        koloda = findViewById(R.id.koloda);
        list = new ArrayList<>();

        adapter = new SwipeAdapter(this, list);
        koloda.setAdapter(adapter);

    }

    public void onFilterPressed(View view){
        Intent i = new Intent(Homepage.this, Filter.class);
        startActivity(i);
    }

    public void onPressedAdoptionHistory(View view){
        Intent i =  new Intent(Homepage.this, AdoptionHistory.class);
        startActivity(i);
    }
}