package org.example;


// kapslar in
public class student {

    private String fname;
    private String lname;
    private String city;
    private String hobby;
    private int student_id;

    public student(int id, String fname, String lname, String city, String hobby) {
        this.student_id = id;
        this.fname = fname;
        this.lname = lname;
        this.city = city;
        this.hobby = hobby;
    }


    public student(int studentId) {
    }

    public student() {

    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getfname() {
        return fname;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public String getlname() {
        return lname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

}
