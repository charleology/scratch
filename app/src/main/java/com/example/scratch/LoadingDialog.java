package com.example.scratch;

import static androidx.appcompat.content.res.AppCompatResources.getDrawable;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class LoadingDialog {

    Activity activity;
    AlertDialog alertDialog;

    LoadingDialog(Activity myActivity) {
        activity = myActivity;
    }


    public void startLoadingDialog(){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(activity, R.style.AlertDialogTheme);
        //builder.setBackground(getDrawable(activity, R.drawable.dialog_bg));
        builder.setCancelable(true);

        ProgressBar pBar = new ProgressBar(activity);
        pBar.setIndeterminate(true);
        pBar.setProgressTintList(ColorStateList.valueOf(Color.rgb(251,82,139)));
        builder.setView(pBar);

        alertDialog = builder.show();
    }

    public void dismissLoadingDialog() {
        alertDialog.dismiss();
    }
}
