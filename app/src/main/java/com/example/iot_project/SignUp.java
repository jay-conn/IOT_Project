package com.example.iot_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    TextView createAccount;
    //EditText emailText, passwordText, usernameText, nameText;
    EditText userNameTextBox, firstPasswordTextBox, secondPasswordTextbox;
    ImageButton button;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);
        userNameTextBox = findViewById(R.id.usernameTextBox); // username
        firstPasswordTextBox = findViewById(R.id.firstPasswordTextBox); // first password
        secondPasswordTextbox = findViewById(R.id.secondPasswordTextBox); // second password
        db = new DBHelper(this);


        ImageButton button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Add to DB then Redirect
                String username = userNameTextBox.getText().toString();
                String password = firstPasswordTextBox.getText().toString();
                String secondPassword = secondPasswordTextbox.getText().toString();
                if(password.equals(secondPassword)){
                    if(db.insertUserData(username, password)){
                        Toast.makeText(SignUp.this, "User Registered",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(SignUp.this, "User Registration Failed",Toast.LENGTH_LONG).show();
                    }



                }
                else{
                    Toast.makeText(SignUp.this, "Password is not matching! Try Again",Toast.LENGTH_LONG).show();
                }

            }
        });


        //Setting up text button
        TextView tv = (TextView) findViewById(R.id.createAccount);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do stuff
                goToLoginWindow();
            }
        });


    }


    private void goToLoginWindow() {
        Intent intentLogin = new Intent(SignUp.this, Login.class);
        startActivity(intentLogin);
    }
}