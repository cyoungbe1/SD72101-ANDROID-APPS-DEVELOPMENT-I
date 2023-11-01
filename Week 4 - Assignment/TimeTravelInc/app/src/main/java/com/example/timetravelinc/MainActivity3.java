package com.example.timetravelinc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Intent previousActivity = getIntent();


        if (previousActivity != null) {


            String spinnerdestination = previousActivity.getStringExtra("destination");

            TextView introsegment = (TextView)findViewById(R.id.destinationintro);
            introsegment.setText(introsegment.getText() + spinnerdestination);

            String itinerary = previousActivity.getStringExtra("itinerary");
            TextView itinerarydescription = (TextView) findViewById(R.id.itinerarydescrip);
            itinerarydescription.setText(itinerarydescription.getText() + itinerary);





            String nameofimg = getIntent().getStringExtra("locationimage");



            int imageId = getResources().getIdentifier(nameofimg, null, null);
            ImageView image = findViewById(R.id.locationpicture);
            image.setImageResource(imageId);





        }
    }

}
