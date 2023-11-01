package com.example.apartmentlikes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void viewlikesbtn(View v) {
        Intent nextActivity = new Intent(this, MainActivity2.class);


        startActivity(nextActivity);
    }


    public void addalikebtn(View v) {
        Intent nextActivity3 = new Intent(this, MainActivity3.class);


        startActivity(nextActivity3);

    }

    public void saveimagepref1(View v) {


        SharedPreferences bgshared = getSharedPreferences("background", MODE_PRIVATE);
        SharedPreferences.Editor editor = bgshared.edit();
        editor.putString("BKGRND", "apt1").commit();




    }

    public void saveimagepref2(View v) {

        SharedPreferences bgshared = getSharedPreferences("background", MODE_PRIVATE);
        SharedPreferences.Editor editor = bgshared.edit();
         editor.putString("BKGRND", "apt2").commit();

    }

    public void saveimagepref3(View v) {

        SharedPreferences bgshared = getSharedPreferences("background", MODE_PRIVATE);
        SharedPreferences.Editor editor = bgshared.edit();
        editor.putString("BKGRND", "apt3").commit();

    }



        // String sharedpreference1 = getPackageName() + "apartments";

       // SharedPreferences sharedpref1 = getSharedPreferences(sharedpreference1, MODE_PRIVATE);
       // SharedPreferences.Editor editor = sharedpref1.edit();
       // editor.putString("BKGRND_ACTIVITY1", "apartments").commit();




}