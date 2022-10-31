package com.example.attendencetrackker;

public class SetAttendence {

    private String name;
    private String attend;

    public SetAttendence(String name, String attend) {
        this.name = name;
        this.attend = attend;
    }

    public SetAttendence() {
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

}
