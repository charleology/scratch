package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baoyachi.stepview.VerticalStepView;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Timeline extends AppCompatActivity {

    DrawerLayout timelineDrawer;
    ImageView filterImgview, menuImgview, closeDrawerBtn;
    TextView headerTitle;
    Button timelineCancelBtn, timelineSetAppBtn, timelineSetAppCancelBtn;
    VerticalStepView timelineStepView;
    LinearLayout timelineCancelLayout, timelineSetAppLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        getSupportActionBar().hide();

        timelineDrawer = (DrawerLayout) findViewById(R.id.timelineDrawer);
        View view = findViewById(R.id.headerLayout);
        filterImgview = (ImageView) findViewById(R.id.filterImgview);
        headerTitle = (TextView) findViewById(R.id.headerTitle);
        menuImgview = (ImageView) findViewById(R.id.menuImgview);
        closeDrawerBtn = (ImageView) findViewById(R.id.closeDrawerBtn);
        timelineCancelBtn = (Button) findViewById(R.id.timelineCancelBtn);
        timelineStepView = (VerticalStepView) findViewById(R.id.timelineStepview);
        timelineCancelLayout = (LinearLayout) findViewById(R.id.timelineCancelLayout);
        timelineSetAppLayout = (LinearLayout) findViewById(R.id.timelineSetAppLayout);
        timelineSetAppBtn = (Button) findViewById(R.id.timelineSetAppBtn);
        timelineSetAppCancelBtn = (Button) findViewById(R.id.timelineSetAppCancelBtn);

        filterImgview.setVisibility(View.INVISIBLE);
        headerTitle.setText("Progress");

        timelineCancelLayout.setVisibility(View.VISIBLE);
        timelineSetAppLayout.setVisibility(View.GONE);

        List<String> sources = new ArrayList<>();
        sources.add("Send Request");
        sources.add("Awaiting Approval");
        sources.add("Request Approved");
        sources.add("Set Appointment");
        sources.add("Appointment Confirmed");
        sources.add("Adoption Successful");

        timelineStepView.setStepsViewIndicatorComplectingPosition(0)
                .reverseDraw(false)
                .setStepViewTexts(sources)
                .setLinePaddingProportion(0.65f)
                //complete
                .setStepsViewIndicatorCompletedLineColor(ContextCompat.getColor(this, R.color.pink))
                .setStepViewComplectedTextColor(Color.BLACK)
                .setStepsViewIndicatorCompleteIcon(getDrawable(R.drawable.task_complete))
                //uncompleted
                .setStepViewUnComplectedTextColor(ContextCompat.getColor(this, R.color.gray))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this,R.color.gray))
                .setStepsViewIndicatorAttentionIcon(getDrawable(R.drawable.task_ongoing))
                //default
                .setStepsViewIndicatorDefaultIcon(getDrawable(R.drawable.task_icon))
                .setStepsViewIndicatorUnCompletedLineColor(ContextCompat.getColor(this, R.color.gray))
                .setTextSize(13);

    }

    public void onCancelPressed(View view){
        timelineCancelLayout.setVisibility(View.GONE);
        timelineSetAppLayout.setVisibility(View.VISIBLE);
        timelineStepView.setStepsViewIndicatorComplectingPosition(3);
    }

    public void onSetAppPressed(View view){
        timelineCancelLayout.setVisibility(View.VISIBLE);
        timelineSetAppLayout.setVisibility(View.GONE);
        timelineStepView.setStepsViewIndicatorComplectingPosition(5);
    }

    public void onSetAppCancelPressed(View view){
        timelineCancelLayout.setVisibility(View.VISIBLE);
        timelineSetAppLayout.setVisibility(View.GONE);
        timelineStepView.setStepsViewIndicatorComplectingPosition(0);
    }

    public void onPressedMenu(View view){
        timelineDrawer.openDrawer(GravityCompat.END);
    }

    public void onPressedCloseDrawer(View view){
        timelineDrawer.closeDrawer(GravityCompat.END);
    }

    public void onPressedAdoptionHistory(View view){
        Intent i =  new Intent(Timeline.this, AdoptionHistory.class);
        startActivity(i);
    }

    public void onPressedAboutOffice(View view){
        Intent i = new Intent(Timeline.this, AboutTheOffice.class);
        startActivity(i);
    }

    public void onPressedAboutUs(View view){
        Intent z = new Intent(Timeline.this, AboutUs.class);
        startActivity(z);
    }

    public void onEditProfilePressed(View view){
        Intent i = new Intent(Timeline.this, EditProfile.class);
        startActivity(i);
    }

}