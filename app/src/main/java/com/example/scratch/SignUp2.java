package com.example.scratch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.io.BufferedInputStream;
import java.net.Inet4Address;
import java.util.Arrays;

public class SignUp2 extends AppCompatActivity {

    Button btnCreate;
    ImageView ivPicture;
    EditText etAddress;
    Spinner spinBarangay;
    EditText spinMunicipality;
    EditText spinProvince;
    EditText etZip;

    private static final int PICK_IMAGE = 1;
    private Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_two);
        getSupportActionBar().hide();

        btnCreate = (Button) findViewById(R.id.btnsignupCreate);
        ivPicture = (ImageView) findViewById(R.id.ivsignupPicture);
        etAddress = (EditText) findViewById(R.id.tfsignupAddress);
        spinBarangay = (Spinner) findViewById(R.id.spsignupBarangay);
        spinMunicipality = (EditText) findViewById(R.id.spsignupMunicipality);
        spinProvince = (EditText) findViewById(R.id.spsignupProvince);
        etZip = (EditText) findViewById(R.id.tfsignupZip);

        spinMunicipality.setText("City of San Jose del Monte");
        spinProvince.setText("Bulacan");
        etZip.setText("3023");

        //String[] brgy = getResources().getStringArray(R.array.Barangay);

        String[] first = getResources().getStringArray(R.array.Gender);
        String[] second = getResources().getStringArray(R.array.Barangay);

        String[] both = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, both, first.length, second.length);

        ArrayAdapter<String> barangayAdapter = new ArrayAdapter<String>(this, R.layout.drop_down_items, both) {
            @Override
            public int getCount() {
                return both.length-1;
            }
        };
        spinBarangay.setAdapter(barangayAdapter);
        spinBarangay.setSelection(both.length-1);

        ivPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

                startActivityForResult(chooserIntent, PICK_IMAGE);
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SignUp2.this);
                builder.setTitle(Html.fromHtml("<b>"+"Terms and Conditions"+"</b>"));
                builder.setIcon(getDrawable(R.drawable.circlelogo_gradient));
                builder.setBackground(getDrawable(R.drawable.dialog_bg));
                builder.setMessage(getResources().getString(R.string.msg));

                LinearLayout tnc_layout = new LinearLayout(SignUp2.this);
                tnc_layout.setOrientation(LinearLayout.VERTICAL);
                tnc_layout.setVerticalGravity(10);
                TextView tnc_tv = new TextView(SignUp2.this);
                tnc_tv.setText("Terms and Conditions");
                tnc_tv.setTextColor(getColor(R.color.purple_700));
                tnc_tv.setPadding(60,0,0,0);
                tnc_layout.addView(tnc_tv);
                builder.setView(tnc_layout);

                builder.setPositiveButton("SUBMIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Codes here
                        signuploadingScreen();
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //codes here
                    }
                });
                builder.show();

                tnc_tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showTnc();
                    }
                });
            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            try{
                BufferedInputStream bufferedInputStream = new BufferedInputStream(getContentResolver().openInputStream(data.getData()));
                bmp = BitmapFactory.decodeStream(bufferedInputStream);
                ivPicture.setImageBitmap(bmp);
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(), "Unable to choose file", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void back(View view){
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public void showTnc(){
        Intent i = new Intent(SignUp2.this, TermsConditions.class);
        startActivity(i);
    }

    public void signuploadingScreen(){
        Intent i = new Intent(SignUp2.this, ProcessSignUp.class);
        startActivity(i);
    }
}