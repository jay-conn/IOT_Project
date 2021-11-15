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

    TextView createAccount;

    //EditText usernameText, passwordText;
    EditText userInput, passInput;
    ImageButton buttom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login1);

        ImageButton button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Add to DB then Redirect
                String userText = userInput.getText().toString();
                String passText = passInput.getText().toString();
                if (userText.isEmpty() || passText.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_SHORT).show();
                }
                else{
                    UserDB userDB = UserDB.getUserDB(getApplicationContext());
                    UserDao userDao = userDB.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(userText, passText);
                            if (userEntity == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                String user = userEntity.username;
                                startActivity(new Intent(
                                        Login.this, Home.class)
                                        .putExtra("name", user));
                            }
                        }
                    }).start();
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