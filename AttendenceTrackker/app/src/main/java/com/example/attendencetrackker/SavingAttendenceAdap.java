package com.example.attendencetrackker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SavingAttendenceAdap extends RecyclerView.Adapter<SavingAttendenceAdap.ViewHolder> {

    Context context;
    ArrayList<SetAttendence> arrayList;

    SavingAttendenceAdap(Context context, ArrayList<SetAttendence> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.savingatte,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.stuname.setText(arrayList.get(position).getName());
        holder.attend.setText(arrayList.get(position).getAttend());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView stuname,attend;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stuname=itemView.findViewById(R.id.StuName);
            attend=itemView.findViewById(R.id.attend);

        }
    }

}
