package com.example.attendencetrackker;

import java.util.ArrayList;

public class Date {

    private String date;
    private ArrayList<SetAttendence> list;

    public Date(String date, ArrayList<SetAttendence> list) {
        this.date = date;
        this.list = list;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<SetAttendence> getList() {
        return list;
    }

    public void setList(ArrayList<SetAttendence> list) {
        this.list = list;
    }
}
