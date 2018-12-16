package com.example.acer.driversify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReportDriver extends AppCompatActivity {
    EditText ePlateNum, eViolation, eStatement;
    TextView eName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_driver);
        ePlateNum = findViewById(R.id.etPlateNum);
        eViolation = findViewById(R.id.etViolation);
        eStatement = findViewById(R.id.etStatement);
        eName  = findViewById(R.id.txtname);


        SharedPreferences pref1 = getSharedPreferences("name", MODE_PRIVATE);
        String name = pref1.getString("name", null);
        eName.setText("Hello, " + name);

        SharedPreferences pref = getSharedPreferences("Page1", MODE_PRIVATE);
        String platenumber = pref.getString("plate", null);
        String violation = pref.getString("violation", null);
        String statement = pref.getString("statement", null);

        if(platenumber != null){
            ePlateNum.setText(platenumber);
            eViolation.setText(violation);
            eStatement.setText(statement);
        }
    }

    public void next1(View v){
        String plateNumber = ePlateNum.getText().toString();
        String violation = eViolation.getText().toString();
        String statement = eStatement.getText().toString();

        SharedPreferences sp = getSharedPreferences("Page1", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("plate", plateNumber);
        editor.putString("violation", violation);
        editor.putString("statement", statement);
        editor.commit();


        Intent i = new Intent(this, ReportDriver2.class);
        startActivity(i);

    }
}
