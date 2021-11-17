package com.example.iot_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    TextView usernameBox;
    Button addDevice, listDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usernameBox = findViewById(R.id.name);
        addDevice = findViewById(R.id.addDevice);
        listDevice = findViewById(R.id.listDevice);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String username = extras.getString("username");
            usernameBox.setText(username);
        }
        addDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAddDevice = new Intent(Home.this, AddDevice.class);
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String username = extras.getString("username");
                    intentAddDevice.putExtra("username",username);
                }
                startActivity(intentAddDevice);
            }
        });
        listDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentListDevices = new Intent(Home.this, ListDevices.class);
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String username = extras.getString("username");
                    intentListDevices.putExtra("username",username);
                }
                startActivity(intentListDevices);
            }
        });
    }
}
