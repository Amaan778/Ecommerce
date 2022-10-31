package com.example.attendencetrackker;

import java.util.ArrayList;

public class Constructor {
    private String name;
    private String sub;
    private ArrayList<SetAttendence> date;

    public Constructor(String name, String sub, ArrayList<SetAttendence> date) {
        this.name = name;
        this.sub = sub;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public ArrayList<SetAttendence> getDate() {
        return date;
    }

    public void setDate(ArrayList<SetAttendence> date) {
        this.date = date;
    }
}
