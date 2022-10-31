package com.example.attendencetrackker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class RecylerAdap extends RecyclerView.Adapter<RecylerAdap.ViewHolder>{

    Context context;
    ArrayList<AttendenceConst> arrayList;
    RecylerAdap(Context context, ArrayList<AttendenceConst> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public RecylerAdap.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.studentlistadap,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecylerAdap.ViewHolder holder, int position) {
        holder.textView.setText(arrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,name;
        Button present,absent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.name);
            name=itemView.findViewById(R.id.pre);
            present=itemView.findViewById(R.id.btn);
            absent=itemView.findViewById(R.id.abs);

            present.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Present", Toast.LENGTH_SHORT).show();

                    name.setText("Present");

                    String test = name.getText().toString();
                    String tests = textView.getText().toString();

                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Attendence");

                    Recyclerconst attendence = new Recyclerconst(tests, test,"p");

                    databaseReference.child(tests).setValue(attendence);
                }
            });

            absent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Absent", Toast.LENGTH_SHORT).show();
                    name.setText("Absent");
                    String test = name.getText().toString();
                    String tests = textView.getText().toString();


                    HashMap user=new HashMap();
                    user.put("attend",test);
                    user.put("value","A");

                    DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("Attendence");
                    databaseReference.child(tests).updateChildren(user).addOnSuccessListener(new OnSuccessListener() {
                        @Override
                        public void onSuccess(Object o) {
                            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });

        }
    }
}