package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Backform extends AppCompatActivity {
    EditText etID10,etID11,etID12,etID13,etID14;
    Button btn12;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backform);
        final EditText etID10=findViewById(R.id.etID10);
        final EditText etID11=findViewById(R.id.etID11);
        final EditText etID12=findViewById(R.id.etID12);
        final EditText etID13=findViewById(R.id.etID13);
        EditText eiID14=findViewById(R.id.etID14);
        btn12=findViewById(R.id.btn12);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long Redgno=Long.parseLong(etID11.getText().toString().trim());
                int Sem=Integer.parseInt(etID12.getText().toString().trim());
                member.setName(etID10.getText().toString().trim());
                member.setBranch(etID13.getText().toString().trim());
                member.setSubject(etID14.getText().toString().trim());
                Toast.makeText(Backform.this, "data insert successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
