package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bckbtn extends AppCompatActivity {
    Button btn13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bckbtn);
        btn13=findViewById(R.id.btn13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intbckbtn=new Intent(bckbtn.this,Backform.class);
                startActivity(Intbckbtn);
            }
        });
    }
}
