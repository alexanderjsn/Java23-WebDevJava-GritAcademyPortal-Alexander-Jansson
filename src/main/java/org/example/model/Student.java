package org.example.model;

public class Student {
    private int student_id;
    private String Fname;
    private String Lname;
    private String city;
    private String hobby;



    public Student(int studentId, String firstName, String lastName, String city, String hobby) {
        this.student_id = studentId;
        this.Fname = firstName;
        this.Lname = lastName;
        this.city = city;
        this.hobby = hobby;
    }

    public Student(String firstName) {
    }

    // Getter- och sette
    public int getStudentId() {
        return student_id;
    }

    public void setStudentId(int studentId) {
        this.student_id = studentId;
    }

    public String getFirstName() {
        return Fname;
    }

    public void setFirstName(String firstName) {
        this.Fname = firstName;
    }

    public String getLastName() {
        return Lname;
    }

    public void setLastName(String lastName) {
        this.Lname = lastName;
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
