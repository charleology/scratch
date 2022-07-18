package com.example.scratch;

import static com.example.scratch.Header.gotoMessage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

public class Homepage extends AppCompatActivity {

    public DrawerLayout nav_drawer_layout;

    TextView headerTitle;
    ImageView filterImgview, messageImgview, menuImgview;
    Button applyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().hide();

        View view = findViewById(R.id.headerLayout);
        headerTitle = (TextView) findViewById(R.id.headerTitle);
        filterImgview = (ImageView) findViewById(R.id.filterImgview);
        messageImgview = (ImageView) findViewById(R.id.messageImgview);
        applyBtn = (Button) findViewById(R.id.applyBtn);

        filterImgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterDia(Homepage.this);
            }
        });

    }


    //Method for executing Filter Dialog
    public void filterDia(Context context){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        builder.setBackground(getDrawable(R.drawable.dialog_bg));
        builder.setView(R.layout.filter_layout);
        builder.setPositiveButton(Html.fromHtml("<b>"+"APPLY"+"</b>"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Codes here
            }
        });
        builder.setNegativeButton(Html.fromHtml("<b>"+"CANCEL"+"</b>"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //codes here
            }
        });
        builder.show();
    }
}