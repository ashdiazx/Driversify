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

public class LogIn extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

       mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser Users = mAuth.getCurrentUser();

    }

    public void login(View v)
    {
        EditText mEdit;
        EditText pass;
        mEdit=(EditText)findViewById(R.id.etUsername);
        pass=(EditText)findViewById(R.id.etPassword);

        String username=mEdit.getText().toString();
        String password= pass.getText().toString();

        if(username == null || password == null){
            Toast.makeText(LogIn.this, "Enter credentials...",
                    Toast.LENGTH_SHORT).show();
        }

        else {
            mAuth.signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("4ITF", "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();

                                Intent i = new Intent(getBaseContext(), ReportDriver.class);
                                startActivity(i);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("4ITF", "signInWithEmail:failure", task.getException());
                                Toast.makeText(LogIn.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }
    }

    public void signup(View v){
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }
}
