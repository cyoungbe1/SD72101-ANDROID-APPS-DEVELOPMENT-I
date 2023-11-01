package com.example.junkremovalestimator3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Project_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);


    Intent previousActivity = getIntent();


        if (previousActivity != null) {


        String spinnerselection = previousActivity.getStringExtra("load_size");



        TextView projectDetails = (TextView)findViewById(R.id.projectdetails1);
        projectDetails.setText(projectDetails.getText() + spinnerselection);

        String projectDescrip = previousActivity.getStringExtra("projectdescrips");
        TextView pd = (TextView) findViewById(R.id.displayprojectdetails1);
        pd.setText(pd.getText() + projectDescrip);

        String nameofimg = getIntent().getStringExtra("dumpsterimage");



        int imageId = getResources().getIdentifier(nameofimg, null, null);
        ImageView image = findViewById(R.id.imageView2);
        image.setImageResource(imageId);




    }


}

    public void backbutton(View v) {
        Intent previousActivity = new Intent(this, MainActivity.class);


        startActivity(previousActivity);

    }





}

