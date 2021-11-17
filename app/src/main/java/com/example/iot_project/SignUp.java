package com.example.iot_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    TextView createAccount;
    //EditText emailText, passwordText, usernameText, nameText;
    EditText userInput0, userInput, passInput;
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up1);
        userInput0 = findViewById(R.id.userInput0);
        userInput = findViewById(R.id.userInput);
        passInput = findViewById(R.id.passInput);

        ImageButton button = (ImageButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Add to DB then Redirect
                UserEntity userEntity = new UserEntity();
                userEntity.setUsername(userInput0.getText().toString());
                userEntity.setPassword(passInput.getText().toString());

                if (isValid(userEntity)){
                    //add user
                    UserDB userDB = UserDB.getUserDB(getApplicationContext());
                    final UserDao userDao = userDB.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User added", Toast.LENGTH_SHORT).show();
                                    //1 second delay
                                    Handler handler = new Handler();
                                    handler.postDelayed(new Runnable() {
                                        public void run() {
                                    //Go to Login
                                            goToLoginWindow();
                                        }
                                    }, 1000);
                                }
                            });
                        }
                    }).start();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        //Setting up text button
        TextView tv = (TextView) findViewById(R.id.createAccount);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do stuff
                //goToLoginWindow();
                //goToHomeWindow();
            }
        });

        /* nullEmail = (TextView) findViewById(R.id.nullEmail);
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

         */
    }
    private boolean isValid (UserEntity userEntity){
        if (userEntity.getUsername().isEmpty() ||
            userEntity.getPassword().isEmpty() ||
            userEntity.getUsername().isEmpty()) {
            return false;
        }
        return true;
    }

    private void goToLoginWindow() {
        Intent intentLogin = new Intent(SignUp.this, Login.class);
        startActivity(intentLogin);
    }
    private void goToHomeWindow() {
        Intent intentHome = new Intent(SignUp.this, Home.class);
        startActivity(intentHome);
    }
}
