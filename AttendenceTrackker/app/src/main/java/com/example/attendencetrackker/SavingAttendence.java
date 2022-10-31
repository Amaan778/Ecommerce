package com.example.attendencetrackker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.UUID;

public class SavingAttendence extends AppCompatActivity {
    TextView desc,stuname,attend;
    RecyclerView list;
    ArrayList<SetAttendence> arrayList=new ArrayList<>();
    Button btn;

    private Uri uri;
    private String id;

    Spinner spin;
    ArrayList<String> arrIds= new ArrayList<>();
    StorageReference reference= FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_attendence);


        desc=findViewById(R.id.discription);
        list=findViewById(R.id.list);
        btn=findViewById(R.id.btn);

        stuname=findViewById(R.id.StuName);
        attend=findViewById(R.id.attend);




        Intent subjects=getIntent();
        String students=subjects.getStringExtra("subject");
        String dates=subjects.getStringExtra("Date");

        getSupportActionBar().setTitle(students);

        desc.setText(dates);

        list.setLayoutManager(new LinearLayoutManager(this));

        SavingAttendenceAdap adap=new SavingAttendenceAdap(this,arrayList);
        list.setAdapter(adap);

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Attendence");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String namez = String.valueOf(snapshot.child("name").getValue());
                String present= String.valueOf(snapshot.child("attend").getValue());;
                String value=String.valueOf(snapshot.child("value").getValue());
                arrayList.add(new SetAttendence(namez,present));
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



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sub=String.valueOf(students);
                String des = dates;
                String s=spin.getSelectedItem().toString();
                String month=s;
                id= UUID.randomUUID().toString();



                    DatabaseReference data = FirebaseDatabase.getInstance().getReference(sub);


                    Constructor constructor = new Constructor(des, sub, arrayList);

                    data.child(month).child(des).setValue(constructor);


                    Intent intent = new Intent(SavingAttendence.this, TeacherDashboard.class);
                    startActivity(intent);

                    Toast.makeText(SavingAttendence.this, "Attendence Marked Successfully", Toast.LENGTH_SHORT).show();



                    String id=UUID.randomUUID().toString();
                    String d=desc.getText().toString();

                Date date=new Date(d,arrayList);
                FirebaseFirestore.getInstance().collection(s).document(d).set(date);
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