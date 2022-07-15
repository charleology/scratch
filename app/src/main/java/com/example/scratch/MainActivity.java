package com.example.scratch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button signUp, logIn;
    TextView forgotPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT){
        //    getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //    }

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
        builder.setTitle("Forgot Password");
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
        et_recovEmail.setTextSize(15);
        et_recovEmail.setLayoutParams(params);
        et_recovEmail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        recov_layout.addView(et_recovEmail);
        builder.setView(recov_layout);

        builder.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Codes here
                accountRecovDia(context);
            }
        });
        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
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
        builder.setTitle("Account Recovery");
        builder.setIcon(R.drawable.accrecovery_icon);
        builder.setBackground(getDrawable(R.drawable.dialog_bg));
        builder.setMessage(getResources().getString(R.string.accRecovMsg));

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Codes here
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
}