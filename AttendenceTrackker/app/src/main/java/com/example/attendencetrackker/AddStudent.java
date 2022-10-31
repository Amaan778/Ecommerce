package com.example.attendencetrackker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class AddStudent extends AppCompatActivity {
    TextView text;
    EditText name, email,mobile;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        text=findViewById(R.id.text);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.number);
        btnRegister=findViewById(R.id.btnreg);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getText().toString();
                String m=mobile.getText().toString();
                String e=email.getText().toString();
                if (n.isEmpty()){
                    name.setError("Enter name");
                }else if (m.isEmpty()||m.length()>10||m.length()<10){
                    mobile.setError("Enter Mobile no.");
                }else if (e.isEmpty()){
                    email.setError("Enter Email");
                }else {
                    String names = name.getText().toString();
                    String emails = email.getText().toString();
                    String mob = mobile.getText().toString();

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Students");
                    StudentConst studentConst = new StudentConst(names, emails, mob);
                    databaseReference.child(names).setValue(studentConst);
                    Intent intent=new Intent(AddStudent.this,TeacherDashboard.class);
                    Toast.makeText(AddStudent.this, "Student Added", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });
    }
}