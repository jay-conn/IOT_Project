package com.example.iot_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText userNameTextBox, passwordTextBox;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        userNameTextBox = findViewById(R.id.usernameTextBox); // username
        passwordTextBox = findViewById(R.id.passwordTextBox); // first password
        db = new DBHelper(this);

        ImageButton button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = userNameTextBox.getText().toString();
                String password = passwordTextBox.getText().toString();
                if(db.checkLogin(username, password)){
                    //Toast.makeText(Login.this, "User found on the database",Toast.LENGTH_LONG).show();
                    Intent intentHome = new Intent(Login.this, Home.class);
                    intentHome.putExtra("username",username);
                    startActivity(intentHome);
                }else{
                    Toast.makeText(Login.this, "User not found",Toast.LENGTH_LONG).show();
                }

            }
        });


        TextView tv = (TextView) findViewById(R.id.createAccount);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do stuff
                goToSignUpWindow();
            }
        });

       /* nullUsername = (TextView) findViewById(R.id.nullUsername);
        nullPassword = (TextView) findViewById(R.id.nullPassword);
        usernameText = (EditText) findViewById(R.id.usernameTextBox);
        passwordText = (EditText) findViewById(R.id.passwordTextBox);

        nullUsername.setVisibility(View.GONE);
        nullPassword.setVisibility(View.GONE); */
    }

    /* public void checkFieldsAndForwardToHomeScreen(View view) {
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
    } */

    private void goToSignUpWindow() {
        Intent intentSignup = new Intent(Login.this,SignUp.class);
        startActivity(intentSignup);
    }
}