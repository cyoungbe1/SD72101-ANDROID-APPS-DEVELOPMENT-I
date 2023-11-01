package com.example.timetravelinc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void takeoff1(View v) {
        Intent nextActivity = new Intent(this,MainActivity.class );

        startActivity(nextActivity);
    }
}