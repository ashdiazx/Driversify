package com.example.acer.driversify;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser Users = mAuth.getCurrentUser();

    }

    public void signup(View v){

        final EditText fname, lname, platenum, email, pass, confpass;

        email = (EditText)findViewById(R.id.etEmail);
        pass = (EditText)findViewById(R.id.etPass);
        confpass = (EditText)findViewById(R.id.etConfPass);
        fname = (EditText)findViewById(R.id.etFName);
        lname = (EditText)findViewById(R.id.etLName);
        platenum = (EditText)findViewById(R.id.etPNumber);

        String uEmail = email.getText().toString();
        String Pass1 = pass.getText().toString();
        String uPass = confpass.getText().toString();
        final String uFName = fname.getText().toString();
        final String uLName = lname.getText().toString();
        final String uPlateNum = platenum.getText().toString();

        if (Pass1.equals(uPass)){
            mAuth.createUserWithEmailAndPassword(uEmail, uPass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("4ITF", "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                String user_id = mAuth.getCurrentUser().getUid();
                                DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child(user_id);

                                Map newUser = new HashMap();
                                newUser.put("fname", uFName);
                                newUser.put("lname", uLName);
                                newUser.put("plateNum", uPlateNum);

                                current_user_db.setValue(newUser);

                                Toast.makeText(SignUp.this, "Successfully signed up...", Toast.LENGTH_SHORT).show();

                                Intent i = new Intent(getBaseContext(), LogIn.class);
                                startActivity(i);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("4ITF", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUp.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }
        else {
            Toast.makeText(SignUp.this, "Passwords do not match...", Toast.LENGTH_SHORT).show();
        }
        }


}
