package com.example.attendencetrackker;

public class Recyclerconst {
    private  String name;
    private  String attend;
    private String value;

    public Recyclerconst(String name, String attend,String value) {
        this.name = name;
        this.attend = attend;
        this.value =value;
    }

    public Recyclerconst() {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
