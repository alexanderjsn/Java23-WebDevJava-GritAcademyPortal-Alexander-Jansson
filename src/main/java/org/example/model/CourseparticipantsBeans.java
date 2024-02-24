package org.example.model;

import java.io.Serializable;

public class CourseparticipantsBeans implements Serializable {

    private int id;
    private int user_id;
    private int course_id;
    private String role;

    public CourseparticipantsBeans(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
