package com.example.scratch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedInputStream;

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

        String[] brgy = getResources().getStringArray(R.array.Barangay);

        ArrayAdapter<String> barangayAdapter = new ArrayAdapter<String>(this, R.layout.drop_down_items, brgy) {
            @Override
            public int getCount() {
                return brgy.length-1;
            }
        };
        spinBarangay.setAdapter(barangayAdapter);
        spinBarangay.setSelection(brgy.length-1);

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
}