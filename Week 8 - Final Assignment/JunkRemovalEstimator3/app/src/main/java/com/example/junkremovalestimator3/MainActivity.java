package com.example.junkremovalestimator3;

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

    public void projectdetailsbtn(View v) {
        Intent nextActivity = new Intent(this, Project_Details.class);

        Spinner loadsizeSpinner = (Spinner) findViewById(R.id.loadsizeSpinner1);
        String spinnerSelectedValue = loadsizeSpinner.getSelectedItem().toString();

        String imagePackage = getPackageName() + "drawable/pngitem_4781444";
        int spinnerSelection = loadsizeSpinner.getSelectedItemPosition();

        switch ((spinnerSelection)) {
            case 0: {
                imagePackage = getPackageName() + ":drawable/pngitem_4781444";
                break;
            }
            case 1: {
                imagePackage = getPackageName() + ":drawable/pngitem_6681756";
                break;
            }
            case 2: {
                imagePackage = getPackageName() + ":drawable/_0_yard_dumpster";
                break;
            }


        }


        String[] projDescriptions = getResources().getStringArray(R.array.projectdescrips);
        String specifiedDescrip = projDescriptions[spinnerSelection];

        nextActivity.putExtra("load_size", spinnerSelectedValue);
        nextActivity.putExtra("projectdescrips", specifiedDescrip);
        nextActivity.putExtra("dumpsterimage", imagePackage);


        nextActivity.putExtra("spinnerValue", loadsizeSpinner.getSelectedItem().toString());


        startActivity(nextActivity);


    }

    public void getestimatebtn(View v) {


        Spinner loadsizeSpinner = (Spinner) findViewById(R.id.loadsizeSpinner1);
        String spinnerSelectedvalue = loadsizeSpinner.getSelectedItem().toString();
        double finalEstimate = 0;

        CheckBox chbx1 = (CheckBox) findViewById(R.id.smallTeam1);
        CheckBox chbx2 = (CheckBox) findViewById(R.id.largeTeam1);

        int smallteamPrice = 50;
        int largeteamPrice = 100;

        if (chbx2.isChecked()) {
            finalEstimate += largeteamPrice;
        } else {
            if (chbx1.isChecked()) {
                finalEstimate += smallteamPrice;
                //save to db number one

            }
        }

        CheckBox smallteamchkbx = (CheckBox) findViewById(R.id.smallTeam1);
        CheckBox largeteamchkbx = (CheckBox) findViewById(R.id.largeTeam1);

        String sizeofTeam = " \n Labor Requirement: ";
        if (smallteamchkbx.isChecked()) sizeofTeam += "Small Team";
        if (largeteamchkbx.isChecked()) sizeofTeam += "Large Team";

        if (sizeofTeam.length() <= 2) sizeofTeam += "Please select a Labor Requirement";


        RadioGroup projectduration = (RadioGroup) findViewById(R.id.projectDuration1);
        int selectedprojectDuration = projectduration.getCheckedRadioButtonId();


        //mode of travel should be first
        //based on the mode, I need to set the tripCost...

        switch (selectedprojectDuration) {
            case R.id.onehour1:
                finalEstimate += 150;
                break;
            case R.id.oneday1:
                finalEstimate += 500;
                break;
            case R.id.twodays1:
                finalEstimate += 1000;
                break;
            case R.id.threedays1:
                finalEstimate += 2000;
                break;
        }

        RadioGroup rg = (RadioGroup) findViewById(R.id.projectDuration1);
        int checkedRadioButton = rg.getCheckedRadioButtonId();

        String radiobuttonselection = "";
        switch (checkedRadioButton) {
            case R.id.onehour1: {
                radiobuttonselection = "1 hour";
                break;
            }
            case R.id.oneday1: {
                radiobuttonselection = "1 day";
                break;
            }
            case R.id.twodays1: {
                radiobuttonselection = "2 days";
                break;
            }
            case R.id.threedays1: {
                radiobuttonselection = "3 days";
                break;
            }


        }


        RadioGroup rg1 = (RadioGroup) findViewById(R.id.packages1);
        int checkedRadioButton1 = rg1.getCheckedRadioButtonId();

        String radiobuttonselection1 = "";
        switch (checkedRadioButton1) {
            case R.id.senior1: {
                radiobuttonselection1 = "Senior";
                break;
            }
            case R.id.student1: {
                radiobuttonselection1 = "Student";
                break;
            }
            case R.id.publicServant1: {
                radiobuttonselection1 = "Public Servant";
                break;
            }


        }


        int seniorDiscount = 50;
        int studentDiscount = 50;
        int publicservantDiscount = 50;
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.packages1);
        ;
        int checkedRadioButton2 = rg2.getCheckedRadioButtonId();

        switch (checkedRadioButton2) {
            case R.id.senior1: {
                finalEstimate -= seniorDiscount;
                break;
            }
            case R.id.student1: {
                finalEstimate -= studentDiscount;
                break;
            }
            case R.id.publicServant1: {
                finalEstimate -= publicservantDiscount;
                break;
            }


        }

        TextView output = (TextView) findViewById(R.id.userinput);
        output.setText(" " + "Project Estimate: \n "+ " \n Project length: " + radiobuttonselection + " \n Discounts: " + radiobuttonselection1 + " discount " + sizeofTeam + " \n Total Estimate: " + String.format("%.2f", finalEstimate) + "$");

        Intent nextActivity3 = new Intent(this, Final_Estimate.class);

        Spinner loadsizeSpinner1 = (Spinner) findViewById(R.id.loadsizeSpinner1);
        String spinnerSelectedValue = loadsizeSpinner1.getSelectedItem().toString();

        String imagePackage = getPackageName() + "drawable/pngitem_4781444";
        int spinnerSelection = loadsizeSpinner1.getSelectedItemPosition();

        switch ((spinnerSelection)) {
            case 0: {
                imagePackage = getPackageName() + ":drawable/pngitem_4781444";
                break;
            }
            case 1: {
                imagePackage = getPackageName() + ":drawable/pngitem_6681756";
                break;
            }
            case 2: {
                imagePackage = getPackageName() + ":drawable/_0_yard_dumpster";
                break;
            }


        }


        String[] projDescriptions = getResources().getStringArray(R.array.projectdescrips);
        String specifiedDescrip = projDescriptions[spinnerSelection];

        nextActivity3.putExtra("load_size", spinnerSelectedValue);
        nextActivity3.putExtra("projectdescrips", specifiedDescrip);
        nextActivity3.putExtra("dumpsterimage", imagePackage);


        nextActivity3.putExtra("spinnerValue", output.getText());

        startActivity(nextActivity3);


    }




}



