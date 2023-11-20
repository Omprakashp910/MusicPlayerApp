package com.example.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        Button start_btn = findViewById(R.id.start_btn);
        Button stop_btn = findViewById(R.id.stop_btn);

        //Now Lets create our service . For it first we need to create a class
        //1. Create Class in MainActivity folder and new class will extend MainActivity Class

    start_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent serviceIntent = new Intent(getApplicationContext(),MyCustomService.class);

            startService(serviceIntent);
        }
    });

    stop_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent serviceIntent = new Intent(getApplicationContext(),MyCustomService.class);
            stopService(serviceIntent);
        }
    });

    }
}