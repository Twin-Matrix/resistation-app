package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class spinner extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText etID;
    Button btn9;
    String item;

    @Override
    public void onItemSelected(AdapterView<?>parent,View view,int position,long id) {
        String item=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected"+item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        etID=findViewById(R.id.etID);
        btn9=findViewById(R.id.btn12);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(item.equals("Instrumentation") &&  etID.getText().toString().equals(4));
                Intent intent=new Intent(spinner.this,syllabussss.class);
                startActivity(intent);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        List<String> categories = new ArrayList<String>();
        categories.add("Instrumentation");
        categories.add("ComputerScience");
        categories.add("Electrical");
        categories.add("Civil");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }}


