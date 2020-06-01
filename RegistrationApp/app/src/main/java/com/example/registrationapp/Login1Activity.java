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
import com.google.firebase.auth.FirebaseUser;

public class Login1Activity extends AppCompatActivity {
    EditText edTx3,edTx4;
    Button btnclick1;
    TextView txResult2;
    FirebaseAuth mfirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        mfirebaseAuth=  FirebaseAuth.getInstance();
        edTx3=findViewById(R.id.edTx3);
        edTx4=findViewById(R.id.edTx4);
        btnclick1=findViewById(R.id.btnclick1);
        txResult2=findViewById(R.id.txResult2);
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser=mfirebaseAuth.getCurrentUser();
                if (mFirebaseUser!=null){
                    Toast.makeText(Login1Activity.this,"you are logged in",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Login1Activity.this,homescreen.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Login1Activity.this,"please Login",Toast.LENGTH_SHORT).show();
                }

            }
        };
        btnclick1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=edTx3.getText().toString();
                String Password=edTx4.getText().toString();
                if(Email.isEmpty() ){
                    edTx3.setError("Please enter the Email id");
                    edTx3.requestFocus();
                }
                else if (Password.isEmpty()){
                    edTx4.setError("Please enter your password");
                    edTx4.requestFocus();
                }
                else if(Email.isEmpty()&&Password.isEmpty()){
                    Toast.makeText(Login1Activity.this,"Filds are empty!",Toast.LENGTH_SHORT).show();

                }
                else if(!(Email.isEmpty()&&Password.isEmpty())){
                    mfirebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(Login1Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(Login1Activity.this,"Login Error,please login again",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent inttowelcome=new Intent(Login1Activity.this,homescreen.class);
                                startActivity(inttowelcome);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Login1Activity.this,"Error Occured!",Toast.LENGTH_SHORT).show();
                }


            }
        });
        txResult2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intRegister=new Intent(Login1Activity.this,MainActivity.class);
                startActivity(intRegister);

            }
        });


    }
}
