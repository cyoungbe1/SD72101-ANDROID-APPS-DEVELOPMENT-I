package com.example.junkremovalestimator3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Final_Estimate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_estimate);


    Intent previousActivity = getIntent();


         {


            String spinnerloadSize = previousActivity.getStringExtra("load_size");

            TextView  finalEstimate = (TextView) findViewById(R.id.displayfinalEstimate1);
            finalEstimate.setText(finalEstimate.getText() + spinnerloadSize);

            String spinnerValue = previousActivity.getStringExtra("spinnerValue");
            TextView spinnerdescription = (TextView) findViewById(R.id.displayfinalEstimate1);
            spinnerdescription.setText(spinnerdescription.getText() + spinnerValue);


            String nameofimg = getIntent().getStringExtra("dumpsterimage");


            int imageId = getResources().getIdentifier(nameofimg, null, null);
            ImageView image = findViewById(R.id.dumpsterimg1);
            image.setImageResource(imageId);


        }

    }
}
