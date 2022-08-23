package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    Button signUp, logIn;
    TextView forgotPass;
    EditText tfloginPassword;
    LoadingDialog loadingDialog = new LoadingDialog(MainActivity.this);
    static boolean passwordVisible;
    ImageView showHideIv;
    int ctr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
        //    getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //    }

        //for transpa status bar
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        signUp = (Button) findViewById(R.id.btnSignup);
        logIn = (Button) findViewById(R.id.btnLogin);
        forgotPass = (TextView) findViewById(R.id.forgotPassword);
        tfloginPassword = (EditText) findViewById(R.id.tfloginPassword);
        showHideIv = (ImageView) findViewById(R.id.showHideIv);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this,Homepage.class);
                startActivity(i2);
                overridePendingTransition(R.anim.fade_slide_up, R.anim.abc_fade_out);
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(MainActivity.this, SignUp.class);
                startActivity(i1);
            }
        });

        forgotPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotPassDia(MainActivity.this);
            }
        });

    }

    //method for forgot password dialog
    public void forgotPassDia(Context context){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        builder.setTitle(Html.fromHtml("<b>"+"Forgot Password"+"</b>"));
        builder.setIcon(getDrawable(R.drawable.forgotpass_icon));
        builder.setBackground(getDrawable(R.drawable.dialog_bg));
        builder.setMessage("\nEnter registered email address.");

        LinearLayout recov_layout = new LinearLayout(context);
        recov_layout.setOrientation(LinearLayout.VERTICAL);
        recov_layout.setVerticalGravity(10);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        params.setMargins(60,0,60,0);
        EditText et_recovEmail = new EditText(context);
        et_recovEmail.setBackground(getResources().getDrawable(R.drawable.tf_background));
        et_recovEmail.setPadding(30,0,0,0);
        et_recovEmail.setHint("Email Address");
        et_recovEmail.setTextSize(14);
        et_recovEmail.setLayoutParams(params);
        et_recovEmail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        recov_layout.addView(et_recovEmail);
        builder.setView(recov_layout);

        builder.setPositiveButton(Html.fromHtml("<b>"+"SUBMIT"+"</b>"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Codes here
                loadingDialog.startLoadingDialog();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadingDialog.dismissLoadingDialog();
                        accountRecovDia(context);
                    }
                }, 3000);
                //accountRecovDia(context);
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

    //method for Account Recovery Dialog
    public void accountRecovDia(Context context){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
        builder.setTitle(Html.fromHtml("<b>"+"Account Recovery"+"</b>"));
        builder.setIcon(R.drawable.accrecovery_icon);
        builder.setBackground(getDrawable(R.drawable.dialog_bg));
        builder.setMessage(getResources().getString(R.string.accRecovMsg));

        builder.setPositiveButton(Html.fromHtml("<b>"+"OK"+"</b>"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
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

    public void onShowHide(View view){
        if (ctr == 0){
            new Utility().passwordFieldTransformer(tfloginPassword, true);
            showHideIv.setImageDrawable(getDrawable(R.drawable.ic_baseline_visibility_off_24));
            ctr++;
        }
        else {
            new Utility().passwordFieldTransformer(tfloginPassword, false);
            showHideIv.setImageDrawable(getDrawable(R.drawable.ic_baseline_visibility_24));
            ctr--;
        }
    }

    /*public boolean showHidePassword(EditText editText, MotionEvent motionEvent, Boolean passwordVisible, int Right){
        boolean res = false;
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            if (motionEvent.getRawX() >= editText.getRight() - editText.getCompoundDrawables()[Right].getBounds().width()) {
                int selection = editText.getSelectionEnd();
                if (passwordVisible) {
                    //drawable image
                    editText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_24, 0);
                    //for hide password
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    passwordVisible = false;
                } else {
                    //drawable image
                    editText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_visibility_off_24, 0);
                    //for show password
                    editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    passwordVisible = true;
                }
                editText.setSelection(selection);
                res = true;
            }
        }
        return res;
    }*/
}