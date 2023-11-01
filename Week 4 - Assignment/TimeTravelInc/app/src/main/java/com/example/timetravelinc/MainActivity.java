package com.example.timetravelinc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void moredetailsbtn(View v) {
        Intent nextActivity = new Intent(this,MainActivity2.class );
        // .putExtra (key, value)

        Spinner userdestination = (Spinner) findViewById(R.id.userdestination);
        String spinnerSelectedValue = userdestination.getSelectedItem().toString();

        String imagePackage = getPackageName() + "drawable/greatwallofchina";
        int spinnerSelection = userdestination.getSelectedItemPosition();

        switch ((spinnerSelection)) {
            case 0: {
                imagePackage = getPackageName() + ":drawable/greatwallofchina";
                break;
            }
            case 1: {
                imagePackage = getPackageName() + ":drawable/colosseuminrome";
                break;
            }
            case 2: {
                imagePackage = getPackageName() + ":drawable/machupicchuinperu";
                break;
            }
            case 3: {
                imagePackage = getPackageName() + ":drawable/chechenitzainmexico";
                break;
            }
            case 4: {
                imagePackage = getPackageName() + ":drawable/tajmahalinindia";
                break;
            }
            case 5: {
                imagePackage = getPackageName() + ":drawable/christtheredeemerinbrazil";
                break;
            }



            }


                  String[] destDescriptions = getResources().getStringArray(R.array.destdescrips);
                  String specifiedDescrip = destDescriptions[spinnerSelection];

                  nextActivity.putExtra("destination", spinnerSelectedValue );
                  nextActivity.putExtra("destdescrips", specifiedDescrip );
                  nextActivity.putExtra("locationimage", imagePackage );



                  nextActivity.putExtra("spinnerValue", userdestination.getSelectedItem().toString());








        startActivity(nextActivity);
    }













    public void getuserinput (View v) {
        Spinner destination = (Spinner) findViewById(R.id.userdestination);
        String spinnerSelectedvalue = destination.getSelectedItem().toString();


        RadioGroup tripLengthGroup = (RadioGroup) findViewById(R.id.tripduration);
        int selectedTripLength = tripLengthGroup.getCheckedRadioButtonId();
        double tripCost = 0;

        //mode of travel should be first
        //based on the mode, I need to set the tripCost...

        switch (selectedTripLength) {
            case R.id.fourdays:
                tripCost += 0;
                break;
            case R.id.oneweek:
                tripCost += 1200;
                break;
            case R.id.twoweeks:
                tripCost += 4000;
                break;
            case R.id.onemonth:
                tripCost += 9600;
                break;
        }

        //RadioGroup packageGroup = ....
        //swtich case here, and we need to do tripCost += 999; with correct amount


        RadioGroup rg = (RadioGroup) findViewById(R.id.tripduration);
        int checkedRadioButton = rg.getCheckedRadioButtonId();

        String radiobuttonselection = "";
        switch (checkedRadioButton) {
            case R.id.fourdays: {
                radiobuttonselection = "4 days";
                break;
            }
            case R.id.oneweek: {
                radiobuttonselection = "1 week";
                break;
            }
            case R.id.twoweeks: {
                radiobuttonselection = "2 weeks";
                break;
            }
            case R.id.onemonth: {
                radiobuttonselection = "1 month";
                break;
            }


        }


        // int fourday = 0;
        // int weex = 1200;
        // int twoWeex = 4000;
        // int mont = 9600;
        // int cost;


        RadioGroup rg1 = (RadioGroup) findViewById(R.id.packages);
        int checkedRadioButton1 = rg1.getCheckedRadioButtonId();

        String radiobuttonselection1 = "";
        switch (checkedRadioButton1) {
            case R.id.standard: {
                radiobuttonselection1 = "Standard";
                break;
            }
            case R.id.deluxe: {
                radiobuttonselection1 = "Deluxe";
                break;
            }
            case R.id.firstclass: {
                radiobuttonselection1 = "First Class";
                break;
            }


        }



        int standardPackage = 3000;
        int deluxePackage = 5000;
        int firstclassPackage = 7000;
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.packages);;
        int checkedRadioButton2 = rg2.getCheckedRadioButtonId();

        switch (checkedRadioButton2) {
            case R.id.standard: {
                tripCost += standardPackage;
                break;
            }
            case R.id.deluxe: {
                tripCost += deluxePackage;
                break;
            }
            case R.id.firstclass: {
                tripCost += firstclassPackage;
                break;
            }


        }


        CheckBox chbx1 = (CheckBox) findViewById(R.id.air);
        CheckBox chbx2 = (CheckBox) findViewById(R.id.airandwater);

        int airandwaterPrice = 2500;
        int airPrice = 0;

        if (chbx2.isChecked()) {
            tripCost += airandwaterPrice;
        } else {
            if (chbx1.isChecked()) {
                tripCost += airPrice;
                //save to db number one

            }
        }


        //based on the mode, I need to set the tripCost...


        //modeoftraveltext.setText("Travel cost: " + String.format("%.2f", tripCost));


        CheckBox airchbx = (CheckBox) findViewById(R.id.air);
        CheckBox airandwaterchbx = (CheckBox) findViewById(R.id.airandwater);

        String modeoftravel = " by way of ";
        if (airchbx.isChecked()) modeoftravel += "Air";
        if (airandwaterchbx.isChecked()) modeoftravel += "Air and Water";

        if (modeoftravel.length() <= 2) modeoftravel += "please select a mode of travel";

        TextView output = (TextView) findViewById(R.id.userinput);
        output.setText("Destination: " + spinnerSelectedvalue + " for " + radiobuttonselection + " with " + radiobuttonselection1 + " package " + modeoftravel + " at a cost of " + String.format("%.2f", tripCost) + "$");


        Intent nextActivity3 = new Intent(this, MainActivity3.class);

        Spinner userdestination = (Spinner) findViewById(R.id.userdestination);
        String spinnerSelectedValue = userdestination.getSelectedItem().toString();

        String imagePackage = getPackageName() + "drawable/greatwallofchina";
        int spinnerSelection = userdestination.getSelectedItemPosition();

        switch ((spinnerSelection)) {
            case 0: {
                imagePackage = getPackageName() + ":drawable/greatwallofchina";
                break;
            }
            case 1: {
                imagePackage = getPackageName() + ":drawable/colosseuminrome";
                break;
            }
            case 2: {
                imagePackage = getPackageName() + ":drawable/machupicchuinperu";
                break;
            }
            case 3: {
                imagePackage = getPackageName() + ":drawable/chechenitzainmexico";
                break;
            }
            case 4: {
                imagePackage = getPackageName() + ":drawable/tajmahalinindia";
                break;
            }
            case 5: {
                imagePackage = getPackageName() + ":drawable/christtheredeemerinbrazil";
                break;
            }


        }


        String[] destDescriptions = getResources().getStringArray(R.array.destdescrips);
        String specifiedDescrip = destDescriptions[spinnerSelection];

        nextActivity3.putExtra("destination", spinnerSelectedValue);
        nextActivity3.putExtra("destdescrips", specifiedDescrip);
        nextActivity3.putExtra("locationimage", imagePackage);


        nextActivity3.putExtra("itinerary", output.getText());

        startActivity(nextActivity3);


    }

    }


