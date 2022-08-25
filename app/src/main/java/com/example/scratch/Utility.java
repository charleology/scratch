package com.example.scratch;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;
import android.widget.EditText;

public class Utility {

    public void passwordFieldTransformer(EditText field, boolean visible){
        field.setTransformationMethod(visible ? null : new PasswordTransformationMethod());
    }
}
