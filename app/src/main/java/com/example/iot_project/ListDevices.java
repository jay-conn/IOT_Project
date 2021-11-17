package com.example.iot_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ListDevices extends AppCompatActivity {

    RecyclerView devices;
    private ArrayList<DeviceInfo> dataHolder = new ArrayList<>();
    DBHelper db;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_list_devices);
        devices = (RecyclerView) findViewById(R.id.devices);
        backButton = findViewById(R.id.backButton);
        devices.setLayoutManager(new LinearLayoutManager(ListDevices.this));
        db = new DBHelper(ListDevices.this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String username = extras.getString("username");
            Cursor cursor =  db.getRegisteredDevices(username);
            while(cursor.moveToNext()){
                DeviceInfo obj = new DeviceInfo(cursor.getString(1),cursor.getString(0),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                dataHolder.add(obj);
            }
            MyAdapter adapter = new MyAdapter(dataHolder);
            devices.setAdapter(adapter);
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(ListDevices.this, Home.class);
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String username = extras.getString("username");
                    intentHome.putExtra("username",username);
                }
                startActivity(intentHome);
            }
        });

    }
}