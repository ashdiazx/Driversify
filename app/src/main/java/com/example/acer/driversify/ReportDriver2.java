package com.example.acer.driversify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ReportDriver2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_driver2);
    }

    public void next(View v){
        Intent i = new Intent(this, ReportDriver3.class);
        startActivity(i);
    }

    public void choosePhoto(View vi){
        Toast.makeText(this, "Upload Photo...", Toast.LENGTH_LONG).show();
    }

    public void submitGeotag(View v){
        Toast.makeText(this, "Submit Geotag...", Toast.LENGTH_LONG).show();
    }
}
