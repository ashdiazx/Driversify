package com.example.acer.driversify;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadPage extends AppCompatActivity {
    private Handler loadingHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_page);
        loadingHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                try {
                    //Go to next page
                    Intent intent = new Intent(getApplicationContext(), LogIn.class);
                    startActivity(intent);
                    finish();
                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }, 3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loadingHandler.removeCallbacksAndMessages(null);
    }
}
