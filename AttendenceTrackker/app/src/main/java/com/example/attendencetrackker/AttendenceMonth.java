package com.example.attendencetrackker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;

import java.util.ArrayList;

public class AttendenceMonth extends AppCompatActivity {
    Button report;
    TableLayout student;
    Spinner spin;
    ArrayList<String> arrIds= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence_month);

        report=findViewById(R.id.report);
        spin=findViewById(R.id.spinner);

        //getting intent
        Intent sub=getIntent();
        String subname=sub.getStringExtra("linux");

        getSupportActionBar().setTitle(subname);
        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s=spin.getSelectedItem().toString();

                Intent intent=new Intent(AttendenceMonth.this,AttendenceTrack.class);
                intent.putExtra("month",s);
                intent.putExtra("subject",subname);
                startActivity(intent);
            }
        });
        //        spinner month
        spin=findViewById(R.id.spinner);

        arrIds.add("Jan");
        arrIds.add("Feb");
        arrIds.add("March");
        arrIds.add("April");
        arrIds.add("May");
        arrIds.add("June");
        arrIds.add("Aug");
        arrIds.add("Sept");
        arrIds.add("Oct");
        arrIds.add("Nov");
        arrIds.add("Dec");

        ArrayAdapter<String> spinner=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrIds);
        spin.setAdapter(spinner);
    }
}