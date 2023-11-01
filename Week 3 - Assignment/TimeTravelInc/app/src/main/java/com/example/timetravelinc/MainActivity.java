package com.example.timetravelinc;

import androidx.appcompat.app.AppCompatActivity;

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
    public void getuserinput (View v) {
        Spinner destination = (Spinner) findViewById(R.id.userdestination);
        String spinnerSelectedvalue = destination.getSelectedItem().toString();

        RadioGroup rg = (RadioGroup) findViewById(R.id.tripduration);
        int checkedRadioButton = rg.getCheckedRadioButtonId();

        String radiobuttonselection = "";
        switch(checkedRadioButton) {
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

        RadioGroup rg1 = (RadioGroup) findViewById(R.id.packages);
        int checkedRadioButton1 = rg1.getCheckedRadioButtonId();

        String radiobuttonselection1 = "";
        switch(checkedRadioButton1) {
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

        CheckBox airchbx = (CheckBox) findViewById(R.id.air);
        CheckBox airandwaterchbx = (CheckBox) findViewById(R.id.airandwater);

        String modeoftravel = " by way of ";
        if (airchbx.isChecked()) modeoftravel += "Air";
        if (airandwaterchbx.isChecked()) modeoftravel += "Air and Water";

        if (modeoftravel.length() <= 2) modeoftravel += "please select a mode of travel";

        TextView output = (TextView) findViewById(R.id.userinput);
        output.setText("Destination: " + spinnerSelectedvalue + " for " + radiobuttonselection + " with " + radiobuttonselection1 + " package" + modeoftravel);
    }
}
