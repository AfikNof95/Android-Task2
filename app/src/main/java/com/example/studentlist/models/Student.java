package com.example.studentlist.models;

public class Student {
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private String avatarPath;
    private boolean isChecked;

    public Student(String id, String name, String phoneNumber, String address, String avatarPath, boolean isChecked) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.avatarPath = avatarPath;
        this.isChecked = isChecked;
    }

    public Student(){
        this.id = "";
        this.name = "";
        this.phoneNumber = "";
        this.address = "";
        this.avatarPath = "";
        this.isChecked = false;
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public boolean getIsChecked() {
        return this.isChecked;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setID(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAvatarPath(String newPath) {
        this.avatarPath = newPath;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public void update(Student st) {
        this.id = st.getID();
        this.name = st.getName();
        this.phoneNumber = st.getPhoneNumber();
        this.address = st.getAddress();
        this.avatarPath = st.getAvatarPath();
        this.isChecked = st.getIsChecked();
    }
}
