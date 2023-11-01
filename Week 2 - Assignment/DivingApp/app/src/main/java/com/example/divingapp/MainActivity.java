package com.example.divingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateinputValues(View v) {
        EditText userinput = (EditText) findViewById(R.id.inputvaluermv);
        String uservalue = userinput.getText().toString();
        double rmvVal = Double.parseDouble(uservalue);


        EditText userinput1 = (EditText) findViewById(R.id.inputvaluetankvolume);
        String uservalue1 = userinput1.getText().toString();
        double tankvolumeVal = Double.parseDouble(uservalue1);


        EditText userinput2 = (EditText) findViewById(R.id.inputvaluedepth);
        String uservalue2 = userinput2.getText().toString();
        double depthVal = Double.parseDouble(uservalue2);

        EditText userinput3 = (EditText) findViewById(R.id.inputvaluesap);
        String uservalue3 = userinput3.getText().toString();
        double sapVal = Double.parseDouble(uservalue3);

        EditText userinput4 = (EditText) findViewById(R.id.inputvaluereserve);
        String uservalue4 = userinput4.getText().toString();
        double reserveVal = Double.parseDouble(uservalue4);


        double sacVal = rmvVal / tankvolumeVal;
        double pressureVal = (depthVal * 0.3048) / 10 + 1;
        double airconsumptionrateVal = sacVal * pressureVal;
        double availableairpressureVal = sapVal - reserveVal;
        double airinminsVal = (availableairpressureVal) / (airconsumptionrateVal);

        //String outputmsg = "Answer" + airinminsVal + "minutes";
        TextView result = (TextView) findViewById(R.id.displayresult);
         result.setText(String.format("Answer: %.2f" , airinminsVal ));
    }
}

