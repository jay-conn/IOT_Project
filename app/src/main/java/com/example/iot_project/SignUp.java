package com.example.iot_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    TextView nullEmail, nullPassword, nullUsername, nullName;
    EditText emailText, passwordText, usernameText, nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);

        nullEmail = (TextView) findViewById(R.id.nullEmail);
        nullPassword = (TextView) findViewById(R.id.nullPassword);
        nullUsername = (TextView) findViewById(R.id.nullUsername);
        nullName = (TextView) findViewById(R.id.nullName);

        emailText = (EditText) findViewById(R.id.emailTextBox);
        passwordText = (EditText) findViewById(R.id.passwordTextBox);
        usernameText = (EditText) findViewById(R.id.usernameTextBox);
        nameText = (EditText) findViewById(R.id.nameTextBox);

        nullEmail.setVisibility(View.GONE);
        nullPassword.setVisibility(View.GONE);
        nullUsername.setVisibility(View.GONE);
        nullName.setVisibility(View.GONE);
    }

    public void checkFieldsAndForwardToLogin(View view) {
        boolean emptyFieldsDetected = false;
        if(emailText.getText().toString().matches("")){
            nullEmail.setVisibility(View.VISIBLE);
            emptyFieldsDetected = true;
        }
        if(passwordText.getText().toString().matches("")){
            nullPassword.setVisibility(View.VISIBLE);
            emptyFieldsDetected = true;
        }
        if(usernameText.getText().toString().matches("")){
            nullUsername.setVisibility(View.VISIBLE);
            emptyFieldsDetected = true;
        }
        if(nameText.getText().toString().matches("")){
            nullName.setVisibility(View.VISIBLE);
            emptyFieldsDetected = true;
        }
        if(!emptyFieldsDetected){
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        }
    }
}