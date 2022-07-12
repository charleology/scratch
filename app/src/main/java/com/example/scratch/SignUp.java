package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class SignUp extends AppCompatActivity {

    ImageView backButton;
    EditText fieldDate;
    Spinner gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        backButton = (ImageView) findViewById(R.id.btnBack);
        fieldDate = (EditText) findViewById(R.id.tfsignupBirthday);

        MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(SignUp.this, MainActivity.class);
                startActivity(i1);
                finish();
            }
        });

        fieldDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.show(getSupportFragmentManager(), "Material_Date_Picker");
                datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        fieldDate.setText(datePicker.getHeaderText());
                    }
                });
            }
        });

       gender= findViewById(R.id.spin_gender);
       String[] gen = {"Male", "Female"};
        ArrayList<String> genderList = new ArrayList<>(Arrays.asList(gen));
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, R.layout.drop_down_items,genderList);
        gender.setAdapter(genderAdapter);

    }
}