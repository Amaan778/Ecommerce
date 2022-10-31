package com.example.attendencetrackker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class Studentlist extends AppCompatActivity {
    RecyclerView recyclerView;
    Button btnSubmit;
    EditText date;
    ArrayList<AttendenceConst> arrayList=new ArrayList<>();
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference reference=db.getReference().child("Students");



    //calenser
    DatePickerDialog.OnDateSetListener onDateSetListener;

    final Calendar calendar=Calendar.getInstance();
    int year =calendar.get(Calendar.YEAR);
    int month=calendar.get(Calendar.MONTH);
    int day=calendar.get(Calendar.DAY_OF_MONTH);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);

        recyclerView=findViewById(R.id.recycler);
        btnSubmit=findViewById(R.id.btnSubmit);

        date=findViewById(R.id.Date);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecylerAdap adap=new RecylerAdap(this,arrayList);
        recyclerView.setAdapter(adap);

        if (arrayList.isEmpty()) {

            reference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String namez = String.valueOf(snapshot.child("name").getValue());
                    arrayList.add(new AttendenceConst(namez));
                    adap.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    adap.notifyDataSetChanged();
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

//        sharing intent value

        Intent sub=getIntent();
        String subname=sub.getStringExtra("linux");

        getSupportActionBar().setTitle(subname);




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dte=date.getText().toString();
//
                Intent intent=new Intent(Studentlist.this,SavingAttendence.class);
                intent.putExtra("subject",subname);
                intent.putExtra("Date",dte);
                startActivity(intent);


            }
        });


//        Adding Date on calender


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(Studentlist.this, android.R.style.Theme_Holo_Dialog_MinWidth,onDateSetListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        onDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String dates=dayOfMonth+"-"+month+"-"+year;
                date.setText(dates);
            }
        };




    }
}