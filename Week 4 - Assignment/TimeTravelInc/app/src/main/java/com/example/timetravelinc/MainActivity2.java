package com.example.timetravelinc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent previousActivity = getIntent();


        if (previousActivity != null) {


            String spinnerdestination = previousActivity.getStringExtra("destination");



            TextView locationTitle = (TextView)findViewById(R.id.desttitle);
            locationTitle.setText(locationTitle.getText() + spinnerdestination);

            String desDescrip = previousActivity.getStringExtra("destdescrips");
            TextView dd = (TextView) findViewById(R.id.displaymoredetails);
            dd.setText(dd.getText() + desDescrip);

            String nameofimg = getIntent().getStringExtra("locationimage");



            int imageId = getResources().getIdentifier(nameofimg, null, null);
            ImageView image = findViewById(R.id.imageView1);
            image.setImageResource(imageId);



            // TextView tv = (TextView) findViewById(R.id.displaymoredetails);
            //  tv.setText(tv.getText() + spinnerdestination + "    ");

          //  String[] destinationdescriptions = getResources().getStringArray(R.array.destdescrips);
          //  ImageView image = (ImageView) findViewById(R.id.imageView1);

          //  String imageName = getPackageName() + ":drawable/greatwallofchina" ;
          //  int imageId = getResources().getIdentifier(imageName, null, null);
          //  image.setImageResource(imageId);

          //  String imageName1 = getPackageName() + ":drawable/colosseuminrome" ;
          //  int imageId1 = getResources().getIdentifier(imageName1, null, null);
          //  image.setImageResource(imageId1);


        }


    }

    public void backbutton(View v) {
        Intent previousActivity = new Intent(this, MainActivity.class);


        startActivity(previousActivity);

    }
    //mode of travel should be first

    }




