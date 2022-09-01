package com.example.scratch;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AppointmentDatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DatePickerDialog dpd;

    final int MAX_SELECTABLE_DATE_IN_FUTURE = 365; // 365 days into the future max

    public void onCreate(@NonNull Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Calendar now = Calendar.getInstance();

        dpd = DatePickerDialog.newInstance(
                AppointmentDatePickerFragment.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );

        // restrict to weekdays only
        ArrayList<Calendar> weekdays = new ArrayList<Calendar>();
        Calendar day = Calendar.getInstance();
        day.add(Calendar.DAY_OF_YEAR, 2);
        for (int i = 0; i < MAX_SELECTABLE_DATE_IN_FUTURE; i++) {
            if (day.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && day.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                Calendar d = (Calendar) day.clone();
                weekdays.add(d);
            }
            day.add(Calendar.DATE, 1);
        }
        Calendar[] weekdayDays = weekdays.toArray(new Calendar[weekdays.size()]);
        dpd.setSelectableDays(weekdayDays);
        dpd.show(requireFragmentManager(), "Datepickerdialog");

    }

    ;

    @Override
    public void onDateSet(DatePickerDialog view, int year, int month, int day) {
        String date = "You picked the following date: " + day + "/" + (++month) + "/" + year;
        dpd = null;

        Toast.makeText(getContext(), date, Toast.LENGTH_SHORT).show();
    }
}
