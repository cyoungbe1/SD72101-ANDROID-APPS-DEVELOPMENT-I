package com.example.apartmentlikes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ConstraintLayout background = findViewById(R.id.screenlikes);

        SharedPreferences bgshared = getSharedPreferences("background", MODE_PRIVATE);
        String Bgfromshared = bgshared.getString("BKGRND", "Error");
        if (Bgfromshared.equals("apt1"))
            background.setBackgroundResource(R.drawable.apt1);
        else if (Bgfromshared.equals("apt2"))
            background.setBackgroundResource(R.drawable.apt2);
        else if (Bgfromshared.equals("apt3"))
            background.setBackgroundResource(R.drawable.apt3);


        // SharedPreferences bgshared = getSharedPreferences("apartments", MODE_PRIVATE);

        //String Bgfromshared = bgshared.getString("BKGRND_ACTIVITY1", "Error");


        // ConstraintLayout set1 = (ConstraintLayout) findViewById(R.id.screenlikes);


        // if (Bgfromshared.equals("BKGRND_ACTIVITY1")) {
        // set1.setBackgroundResource(R.drawable.apt1);


        TextView displayData = (TextView) findViewById(R.id.displayInfo);

        String output = "    \n";


        SQLiteDatabase aptlikes = null;


        {

            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1)
                    aptlikes = SQLiteDatabase.openDatabase("/data/data/" + getPackageName() + "/databases/aptlikes.db", null,
                            SQLiteDatabase.OPEN_READONLY);

                String sql = "SELECT * FROM apts ";
                Cursor crs = aptlikes.rawQuery(sql, null);

                if (crs.moveToFirst()) {
                    // if the database has at least 1 record
                    do {
                        // list the records
                        output += crs.getString(0) + "     " +
                                crs.getInt(1) + "    " +
                                crs.getInt(2) + "   \n " +
                                crs.getInt(3) + "    " +
                                crs.getString(4) + "   \n\n ";
                    } while (crs.moveToNext());
                    aptlikes.close();
                }

            } catch (SQLiteException e) {
                output = "Problem with database";
            }
            displayData.setText(output);

        }
    }
}





