package com.example.iot_project;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.iot_project.databinding.ActivityHome2Binding;

public class Home extends AppCompatActivity {
    TextView curName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        curName = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        curName.setText(name);

    }

}