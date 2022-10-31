package com.example.attendencetrackker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TeacherDashboard extends AppCompatActivity {
    TextView student,attendence,track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dashboard);

        student=findViewById(R.id.student);
        attendence=findViewById(R.id.attendence);
        track=findViewById(R.id.track);


        attendence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherDashboard.this, Subjectlist.class);
                startActivity(intent);
            }
        });


        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TeacherDashboard.this,AddStudent.class);
                startActivity(intent);
            }
        });

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(TeacherDashboard.this,SubjectlistTrack.class);
                startActivity(intent);

            }
        });

    }
}