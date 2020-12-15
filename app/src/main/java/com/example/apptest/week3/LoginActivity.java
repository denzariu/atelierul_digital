package com.example.apptest.week3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apptest.R;
import com.google.android.material.textfield.TextInputLayout;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout emailInputLayout;
    TextInputLayout phoneInputLayout;
    EditText emailEditText;
    EditText phoneEditText;
    CheckBox termsAndConditions;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        submitButton = findViewById(R.id.btn_submit);

        emailInputLayout = findViewById(R.id.til_email);
        phoneInputLayout = findViewById(R.id.til_phone);
        termsAndConditions = findViewById(R.id.cb_TnC);

        emailEditText = findViewById(R.id.et_email);
        phoneEditText = findViewById(R.id.et_phone);

        submitButton.setEnabled(termsAndConditions.isChecked());

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { validate();}
            });


        termsAndConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                submitButton.setEnabled(isChecked);
            }
        });
    }

    private void validate() {
        boolean isValid = true;


        if (emailEditText.getText().toString().isEmpty()) {
            emailInputLayout.setError("Invalid Email");
            isValid = false;
        }
        if (phoneEditText.getText().toString().isEmpty()) {
            phoneInputLayout.setError("Invalid Phone.");
            isValid = false;
        }

        if (isValid) {
            Toast.makeText(this, "Everything is ok, logged in!", Toast.LENGTH_LONG).show();
        }
    }

}