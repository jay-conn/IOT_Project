package com.example.iot_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddDevice extends AppCompatActivity {

    Button backButton, addDevice;
    EditText deviceNameTextBox, ipAddressTextBox, areaTextBox;
    DBHelper db;
    Spinner statusSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_device);
        backButton = findViewById(R.id.backButton);
        addDevice = findViewById(R.id.addDevice);
        deviceNameTextBox = findViewById(R.id.deviceNameTextBox);
        ipAddressTextBox = findViewById(R.id.ipAddressTextBox);
        areaTextBox = findViewById(R.id.areaTextBox);
        statusSpinner = findViewById(R.id.statusSpinner);
        EditText mEdit = (EditText) findViewById(R.id.statusString);
        mEdit.setEnabled(false);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(AddDevice.this,R.array.status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(adapter);
        db = new DBHelper(this);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(AddDevice.this, Home.class);
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    String username = extras.getString("username");
                    intentHome.putExtra("username",username);
                }
                startActivity(intentHome);
            }
        });
        addDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deviceName = deviceNameTextBox.getText().toString();
                String ipAddress = ipAddressTextBox.getText().toString();
                String area = areaTextBox.getText().toString();

                String status = statusSpinner.getSelectedItem().toString();
                if(deviceName.isEmpty() || ipAddress.isEmpty() || area.isEmpty()){
                    Toast.makeText(AddDevice.this, "All Fields must be filled",Toast.LENGTH_LONG).show();
                }
                else{
                    Bundle extras = getIntent().getExtras();

                    if (extras != null) {
                        String username = extras.getString("username");
                        if(db.checkDeviceUniqueness(username, deviceName)){
                            if(db.addDevice(username, deviceName, ipAddress, area, status)){
                                Toast.makeText(AddDevice.this, "Successfully registered the device",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(AddDevice.this, "Error when registering in the database!",Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(AddDevice.this, "Device name already exists!",Toast.LENGTH_LONG).show();
                        }
                    }

                }
                Intent intentHome = new Intent(AddDevice.this, Home.class);
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