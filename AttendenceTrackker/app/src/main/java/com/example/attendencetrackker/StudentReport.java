package com.example.attendencetrackker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
public class StudentReport extends AppCompatActivity {
    Button report;
    TableLayout student;
    Spinner spin;
    ArrayList<String> arrIds= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_report);
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
                Intent intent=new Intent(StudentReport.this,FetchReport.class);
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