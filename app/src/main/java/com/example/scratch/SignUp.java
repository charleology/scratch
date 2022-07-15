package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class SignUp extends AppCompatActivity {

    ImageView backButton;
    EditText fieldFname, fieldLname, fieldPassword, fieldConfirmpass,
            fieldEmail, fieldDBirthday, fieldContact;
    Spinner spinGender;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        }

        backButton = (ImageView) findViewById(R.id.btnBack);
        fieldDBirthday = (EditText) findViewById(R.id.tfsignupBirthday);
        next = (Button) findViewById(R.id.btnsignupNext);
        spinGender = findViewById(R.id.spsignupGender);
        fieldFname = (EditText) findViewById(R.id.tfsignupFname);
        fieldLname = (EditText) findViewById(R.id.tfsignupLname);
        fieldPassword = (EditText) findViewById(R.id.tfsignupPassword);
        fieldConfirmpass = (EditText) findViewById(R.id.tfsignupConPassword);
        fieldEmail = (EditText) findViewById(R.id.tfsignupEmail);
        fieldContact = (EditText) findViewById(R.id.tfsignupContact);

        String[] gen = getResources().getStringArray(R.array.Gender);

        MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build();

        fieldDBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.show(getSupportFragmentManager(), "Material_Date_Picker");
                datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        fieldDBirthday.setText(datePicker.getHeaderText());
                    }
                });
            }
        });

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, R.layout.drop_down_items, gen) {
            @Override
            public int getCount() {
                return gen.length-1;
            }
        };
        spinGender.setAdapter(genderAdapter);
        spinGender.setSelection(gen.length-1);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUp.this, SignUp2.class);
                startActivity(i);
            }
        });

    }

    public void back(View view){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}