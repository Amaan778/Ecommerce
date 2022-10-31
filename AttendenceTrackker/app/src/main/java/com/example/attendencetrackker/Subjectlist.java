package com.example.attendencetrackker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Subjectlist extends AppCompatActivity {
    TextView linux,software,ins,iot,game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectlist);

        linux=findViewById(R.id.linux);
        software=findViewById(R.id.Software);
        ins=findViewById(R.id.ins);
        iot=findViewById(R.id.iot);
        game=findViewById(R.id.game);

        linux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Subjectlist.this,Studentlist.class);
                intent.putExtra("linux","Linux Server Administration");
                startActivity(intent);
            }
        });

        software.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Subjectlist.this,Studentlist.class);
                intent.putExtra("linux","Software Testing");
                startActivity(intent);
            }
        });

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Subjectlist.this,Studentlist.class);
                intent.putExtra("linux","Information & Network sec");
                startActivity(intent);
            }
        });

        iot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Subjectlist.this,Studentlist.class);
                intent.putExtra("linux","Architecting of Iot");
                startActivity(intent);
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Subjectlist.this,Studentlist.class);
                intent.putExtra("linux","Game Programming");
                startActivity(intent);
            }
        });
    }


}