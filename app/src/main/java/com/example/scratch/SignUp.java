package com.example.scratch;

import static com.example.scratch.MainActivity.setWindowFlag;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointBackward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Calendar;


public class SignUp extends AppCompatActivity {

    ImageView backButton, signUpPassHide, signUpConPassHide;
    static EditText fieldFname, fieldLname, fieldPassword, fieldConfirmpass,
            fieldEmail, fieldDBirthday, fieldContact;
    Spinner spinGender;
    Button next;
    int ctr = 0, ctr1 = 0;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

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
        signUpPassHide = (ImageView) findViewById(R.id.signUpPassHide);
        signUpConPassHide = (ImageView) findViewById(R.id.signUpConPassHide);

        String[] gen = getResources().getStringArray(R.array.Gender);

        //MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker().setTitleText("Select date").setSelection(MaterialDatePicker.todayInUtcMilliseconds()).build();

        fieldDBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new AppointmentDatePickerFragment();
                newFragment.show(getSupportFragmentManager(), "datePicker");
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

    //date picker fragment
    //only allows 18 years old and above
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            c.add(Calendar.YEAR, -18);
            dialog.getDatePicker().setMaxDate(c.getTimeInMillis());
            return  dialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            fieldDBirthday.setText(month+1+"/"+day+"/"+year);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {

        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    public void onPassShowHide(View view){
        if (ctr == 0){
            new Utility().passwordFieldTransformer(fieldPassword, true);
            signUpPassHide.setImageDrawable(getDrawable(R.drawable.ic_baseline_visibility_24));
            ctr++;
        }
        else {
            new Utility().passwordFieldTransformer(fieldPassword, false);
            signUpPassHide.setImageDrawable(getDrawable(R.drawable.ic_baseline_visibility_off_24));
            ctr--;
        }
    }

    public void onConPassShowHide(View view){
        if (ctr == 0){
            new Utility().passwordFieldTransformer(fieldConfirmpass, true);
            signUpConPassHide.setImageDrawable(getDrawable(R.drawable.ic_baseline_visibility_24));
            ctr++;
        }
        else {
            new Utility().passwordFieldTransformer(fieldConfirmpass, false);
            signUpConPassHide.setImageDrawable(getDrawable(R.drawable.ic_baseline_visibility_off_24));
            ctr--;
        }
    }
}