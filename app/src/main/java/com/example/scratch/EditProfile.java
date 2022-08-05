package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity {

    EditText newPasswordEt, newFnameEt, newLnameEt, newBirthdayEt, newContactEt;
    Spinner newGenderSp;
    TextView requestResetTv, requestDeactTv;
    Button saveChangesBtn;
    ImageView newPictureIv;
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        getSupportActionBar().hide();

        newFnameEt = (EditText) findViewById(R.id.newFnameEt);
        newLnameEt = (EditText) findViewById(R.id.newLnameEt);
        newPasswordEt = (EditText) findViewById(R.id.newPasswordEt);
        newBirthdayEt = (EditText) findViewById(R.id.newBirthdayEt);
        newContactEt = (EditText) findViewById(R.id.newContactEt);
        newGenderSp = (Spinner) findViewById(R.id.newGenderSp);
        requestResetTv = (TextView) findViewById(R.id.requestResetTv);
        requestDeactTv = (TextView) findViewById(R.id.requestDeactTv);
        newPictureIv = (ImageView) findViewById(R.id.newPictureIv);
        saveChangesBtn = (Button) findViewById(R.id.saveChangesBtn);

        newPasswordEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int right=2;
                if(motionEvent.getAction()==MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX()>=newPasswordEt.getRight()-newPasswordEt.getCompoundDrawables()[right].getBounds().width()){
                        int selection = newPasswordEt.getSelectionEnd();
                        if (passwordVisible){
                            //drawable image
                            newPasswordEt.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.ic_baseline_visibility_24,0);
                            //for hide password
                            newPasswordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }else{
                            //drawable image
                            newPasswordEt.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.ic_baseline_visibility_off_24,0);
                            //for show password
                            newPasswordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        newPasswordEt.setSelection(selection);
                        return true;
                    }
                }

                return false;
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