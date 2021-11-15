package com.example.iot_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button signupButton, loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        //Go to login screen after 3 seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                goToSignUpWindow();
            }
        }, 3000);

        /* signupButton = (Button) findViewById(R.id.buttonSignup);
        loginButton = (Button)  findViewById(R.id.buttonLogin);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSignUpWindow();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginWindow();
            }
        }); */
    }

    private void goToLoginWindow() {
        Intent intentLogin = new Intent(MainActivity.this, Login.class);
        startActivity(intentLogin);
    }

    private void goToSignUpWindow() {
        Intent intentSignup = new Intent(MainActivity.this,SignUp.class);
        startActivity(intentSignup);
    }


}