package com.example.attendencetrackker;
import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubjectlistTrack extends AppCompatActivity {
    TextView linux,software,ins,iot,game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectlist_track);

        linux=findViewById(R.id.linux);
        software=findViewById(R.id.Software);
        ins=findViewById(R.id.ins);
        iot=findViewById(R.id.iot);
        game=findViewById(R.id.game);

        linux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SubjectlistTrack.this,AttendenceMonth.class);
                intent.putExtra("linux","Linux Server Administration");
                startActivity(intent);
            }
        });

        software.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SubjectlistTrack.this,AttendenceMonth.class);
                intent.putExtra("linux","Software Testing");
                startActivity(intent);
            }
        });

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SubjectlistTrack.this,AttendenceMonth.class);
                intent.putExtra("linux","Information & Network sec");
                startActivity(intent);
            }
        });

        iot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SubjectlistTrack.this,AttendenceMonth.class);
                intent.putExtra("linux","Architecting of Iot");
                startActivity(intent);
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SubjectlistTrack.this,AttendenceMonth.class);
                intent.putExtra("linux","Game Programming");
                startActivity(intent);
            }
        });
    }


}