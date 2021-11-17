package com.example.iot_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    TextView curName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home0);

        curName = findViewById(R.id.user);
        String name = getIntent().getStringExtra("user");
        curName.setText(name);

    }

}