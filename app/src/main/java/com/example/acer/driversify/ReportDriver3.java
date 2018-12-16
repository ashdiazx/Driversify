package com.example.acer.driversify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ReportDriver3 extends AppCompatActivity {
    TextView tPlateNum, tViolation, tStatement, eName;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_driver3);

        tPlateNum = findViewById(R.id.txtPlateNum);
        tViolation = findViewById(R.id.txtViolation);
        tStatement = findViewById(R.id.txtStatement);

        eName = findViewById(R.id.txtname);

        SharedPreferences pref1 = getSharedPreferences("name", MODE_PRIVATE);
        String name = pref1.getString("name", null);
        eName.setText("Hello, " + name);

        SharedPreferences pref = getSharedPreferences("Page1", MODE_PRIVATE);
        String platenumber = pref.getString("plate", null);
        String violation = pref.getString("violation", null);
        String statement = pref.getString("statement", null);
        tPlateNum.setText(platenumber);
        tViolation.setText(violation);
        tStatement.setText(statement);

        mAuth = FirebaseAuth.getInstance();
    }

    public void submit(View v){
        SharedPreferences pref = getSharedPreferences("Page1", MODE_PRIVATE);
        String platenumber = pref.getString("plate", null);
        String violation = pref.getString("violation", null);
        String statement = pref.getString("statement", null);
        FirebaseUser user = mAuth.getCurrentUser();
        String user_id = mAuth.getCurrentUser().getUid();
        DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Reports").push();


        Map newUser = new HashMap();
        newUser.put("User", user_id);
        newUser.put("PlateNumber", platenumber);
        newUser.put("Violation", violation);
        newUser.put("Statement", statement);

        current_user_db.setValue(newUser);

        SharedPreferences sp = getSharedPreferences("Page1", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("plate", null);
        editor.putString("violation", null);
        editor.putString("statement", null);
        editor.commit();



        Toast.makeText(this, "Successfully submitted...", Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, ReportDriver.class);
        startActivity(i);
    }
}

