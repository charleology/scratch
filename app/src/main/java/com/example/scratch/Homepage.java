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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;
import com.yalantis.library.Koloda;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends AppCompatActivity {

    private SwipeAdapter adapter;
    private List<Integer> list;
    Koloda koloda;

    TextView headerTitle;
    ImageView filterImgview, messageImgview, menuImgview;
    Button applyBtn;
    ImageView heartIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        getSupportActionBar().hide();

        LoadingDialog loadingDialog = new LoadingDialog(Homepage.this);

        View view = findViewById(R.id.headerLayout);
        headerTitle = (TextView) findViewById(R.id.headerTitle);
        filterImgview = (ImageView) findViewById(R.id.filterImgview);
        messageImgview = (ImageView) findViewById(R.id.messageImgview);
        menuImgview = (ImageView) findViewById(R.id.menuImgview);
        applyBtn = (Button) findViewById(R.id.applyBtn);
        heartIcon = (ImageView) findViewById(R.id.heartIcon);

        filterImgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterDia(Homepage.this);
            }
        });

        //Koloda swipe
        koloda = findViewById(R.id.koloda);
        list = new ArrayList<>();

        adapter = new SwipeAdapter(this, list);
        koloda.setAdapter(adapter);

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