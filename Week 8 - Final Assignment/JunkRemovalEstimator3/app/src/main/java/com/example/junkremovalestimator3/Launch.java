package com.example.junkremovalestimator3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Launch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }

    public void launchbtn(View v) {
        Intent nextActivity = new Intent(this,MainActivity.class );

        startActivity(nextActivity);
    }

}