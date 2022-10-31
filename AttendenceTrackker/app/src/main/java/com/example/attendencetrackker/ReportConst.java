package com.example.attendencetrackker;

import java.io.Serializable;
import java.util.ArrayList;

public class ReportConst {

    String name;
    String attend;
    String date;

    public ReportConst( String name,String attend, String date) {
        this.name = name;
        this.attend=attend;
        this.date=date;
    }

    public ReportConst() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
