package com.example.attendencetrackker;

import static java.lang.String.valueOf;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ReportAdap extends RecyclerView.Adapter<ReportAdap.Viewholder> {

    Context context;
    ArrayList<ReportConst> adap;

    public ReportAdap(Context context,ArrayList<ReportConst> adap){
        this.context=context;
        this.adap=adap;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.report,parent,false);
        Viewholder viewholder=new Viewholder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.student.setText(adap.get(position).getName());
        holder.attend.setText(adap.get(position).getAttend());
        holder.date.setText(adap.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return adap.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView student,attend,date;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            student=itemView.findViewById(R.id.name);
            attend=itemView.findViewById(R.id.attend);
            date=itemView.findViewById(R.id.date);
        }
    }
}
