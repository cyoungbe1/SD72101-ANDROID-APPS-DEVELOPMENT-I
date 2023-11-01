package com.example.apartmentlikes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        ConstraintLayout background = findViewById(R.id.addanewlikeLayout);

        SharedPreferences bgshared = getSharedPreferences("background", MODE_PRIVATE);
        String Bgfromshared = bgshared.getString("BKGRND", "Error");
        if (Bgfromshared.equals("apt1"))
            background.setBackgroundResource(R.drawable.apt1);
        else if (Bgfromshared.equals("apt2"))
            background.setBackgroundResource(R.drawable.apt2);
        else if (Bgfromshared.equals("apt3"))
            background.setBackgroundResource(R.drawable.apt3);


    }

    public void aptlikebtn(View v){
        Intent otheractivity = new Intent(this,MainActivity2.class );

        EditText inputaddress = (EditText) findViewById(R.id.addressInput1);
        String inputAddress =  inputaddress.getText().toString();


        EditText inputbedrooms = (EditText) findViewById(R.id.bedroomsInput1);
        String inputBedrooms =  inputbedrooms.getText().toString();
        int inputBedroomsint = Integer.parseInt(inputBedrooms);

        EditText inputbaths  = (EditText) findViewById(R.id.bathsInput1);
        String inputBaths =  inputbaths.getText().toString();
        int inputBathsint = Integer.parseInt(inputBaths);

        EditText inputrent = (EditText) findViewById(R.id.rentInput1);
        String inputRent =  inputrent.getText().toString();
        int inputRentint = Integer.parseInt(inputRent);

        EditText notes = (EditText) findViewById(R.id.notesInput1);
        String inputNotes =  notes.getText().toString();


        SQLiteDatabase aptlikes = null;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                aptlikes = SQLiteDatabase.openDatabase("data/data/" + getPackageName() + "/databases/aptlikes.db", null,
                        SQLiteDatabase.OPEN_READWRITE);

                String insertSQL = "INSERT INTO apts (ADDRESS, NUMBEDRMS, NUMBATHS, MONTHLYRENT, NOTES) ";
                insertSQL += " VALUES ('" + inputAddress + "', " + inputBedroomsint + ", " + inputBathsint + ", " + inputRentint + ", ";
                insertSQL += "'" + inputNotes + "');";

                aptlikes.execSQL(insertSQL);
                aptlikes.close();
            }
        }
        catch(Exception ex){

        }


        startActivity(otheractivity);
    }




}