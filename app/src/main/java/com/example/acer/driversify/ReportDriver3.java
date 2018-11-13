package com.example.acer.driversify;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ReportDriver3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_driver3);
    }

    public void submit(View v){
        Toast.makeText(this, "Successfully submitted...", Toast.LENGTH_LONG).show();
    }
}
