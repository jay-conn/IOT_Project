package com.example.iot_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    TextView nullUsername, nullPassword;

    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        nullUsername = (TextView) findViewById(R.id.nullUsername);
        nullPassword = (TextView) findViewById(R.id.nullPassword);
        usernameText = (EditText) findViewById(R.id.usernameTextBox);
        passwordText = (EditText) findViewById(R.id.passwordTextBox);

        nullUsername.setVisibility(View.GONE);
        nullPassword.setVisibility(View.GONE);
    }

    public void checkFieldsAndForwardToHomeScreen(View view) {
        boolean emptyFieldsDetected = false;
        if(passwordText.getText().toString().matches("")){
            nullPassword.setVisibility(View.VISIBLE);
            emptyFieldsDetected = true;
        }
        if(usernameText.getText().toString().matches("")){
            nullUsername.setVisibility(View.VISIBLE);
            emptyFieldsDetected = true;
        }
        if(!emptyFieldsDetected){
            Toast.makeText(this, "Forward To the Next Window", Toast.LENGTH_SHORT).show();
        }
    }
}