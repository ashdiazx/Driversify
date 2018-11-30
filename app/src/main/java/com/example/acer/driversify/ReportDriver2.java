package com.example.acer.driversify;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class ReportDriver2 extends AppCompatActivity {
    EditText ePlateNum, eViolation, eStatement;
    ImageView img;

    private final int PICK_IMAGE_REQUEST = 71;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_driver2);
        ePlateNum = findViewById(R.id.etPlateNum);
        eViolation = findViewById(R.id.etViolation);
        eStatement = findViewById(R.id.etStatement);
        img = findViewById(R.id.imgReport);
//        btnChoose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                choosePhoto();
//            }
//        });
    }

    public void next(View v){
        Intent i = new Intent(this, ReportDriver3.class);
        startActivity(i);
    }

    public void back(View v){

        Intent i = new Intent(this, ReportDriver.class);
        startActivity(i);
    }

    public void choosePhoto(View v){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
//            filepath = data.getData();
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
//                img.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

}
