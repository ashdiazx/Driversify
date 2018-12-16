package com.example.acer.driversify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class activity_home extends AppCompatActivity {

    private DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    TextView eName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        eName = findViewById(R.id.txtname);

        SharedPreferences pref1 = getSharedPreferences("name", MODE_PRIVATE);
        String name = pref1.getString("name", null);
        eName.setText("Hello, " + name);


    }

    public void report(View v){
        Intent i = new Intent(this, ReportDriver.class);
        startActivity(i);
    }
}
