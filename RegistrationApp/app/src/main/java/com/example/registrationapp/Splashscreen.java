package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class Splashscreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent splashintent=new Intent(Splashscreen.this,MainActivity.class);
                startActivity(splashintent);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
