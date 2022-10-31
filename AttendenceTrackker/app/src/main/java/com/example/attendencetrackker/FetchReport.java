package com.example.attendencetrackker;

import static java.lang.String.valueOf;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Objects;

public class FetchReport extends AppCompatActivity {
    TextView month;
    RecyclerView recyclerView;
    EditText seat;
    Button submit;
    ArrayList<ReportConst> adap = new ArrayList<>();
    private ReportConst reportConst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_report);

//        text=findViewById(R.id.text);
        month = findViewById(R.id.montth);
        recyclerView = findViewById(R.id.recycler);
        seat = findViewById(R.id.seat);
        submit = findViewById(R.id.submit);

        Intent sub = getIntent();
        String subname = sub.getStringExtra("subject");

        String m = sub.getStringExtra("month");

        month.setText(m);
        getSupportActionBar().setTitle(subname);

//        // this is for Student data
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ReportAdap adapter = new ReportAdap(this, adap);
        recyclerView.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int i = 0; i < 31; i++) {

                    String d = seat.getText().toString();
                    int nums = Integer.parseInt(d) - 1;

                    String e = String.valueOf(i);


                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(subname);
                    databaseReference.child(m).child(String.valueOf(i)).child("date").child(String.valueOf(nums)).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {

                            if (task.isSuccessful()) {

                                if (task.getResult().exists()) {

                                    DataSnapshot snapshot = task.getResult();
                                    String date = valueOf(snapshot.child("name").getValue());
                                    String v = valueOf(snapshot.child("value").getValue());
                                    String at = valueOf(snapshot.child("attend").getValue());

//                                    adap.add(new ReportConst(date, at,e));

                                    adap.add(new ReportConst(e, at, date));

                                } else {
                                    Toast.makeText(FetchReport.this, "Second Error", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(FetchReport.this, "error", Toast.LENGTH_SHORT).show();
                            }


                        }


                    });

                }
            }


            
        });
    }
}