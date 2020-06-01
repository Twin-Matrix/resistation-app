package com.example.registrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText edTx3,edTx4;
    Button btnclick1;
    TextView txResult1;
    FirebaseAuth mfirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mfirebaseAuth=  FirebaseAuth.getInstance();
        edTx3=findViewById(R.id.edTx3);
        edTx4=findViewById(R.id.edTx4);
        btnclick1=findViewById(R.id.btnclick1);
        txResult1=findViewById(R.id.txResult1);
        btnclick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=edTx3.getText().toString();
                String Password=edTx4.getText().toString();
                if(Email.isEmpty()){
                    edTx3.setError("Please enter the Email id");
                    edTx3.requestFocus();
                }
                else if (Password.isEmpty()){
                    edTx4.setError("Please enter your password");
                    edTx4.requestFocus();
                }
                else if(Email.isEmpty()&&Password.isEmpty()){
                    Toast.makeText(MainActivity.this,"Filds are empty!",Toast.LENGTH_SHORT).show();

                }
                else if(!(Email.isEmpty()&&Password.isEmpty())){
                    mfirebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(MainActivity.this,"Registration Unsuccessful,please try again",Toast.LENGTH_SHORT).show();
                            }
                            else{
                              startActivity(new Intent(MainActivity.this,Login1Activity.class));
                              Toast.makeText(MainActivity.this,"work successfully",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity.this,"Error Occured!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        txResult1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Login1Activity.class);
                startActivity(i);
            }
        });
    }
}
