package org.example.model;


public class CourseParticipant {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private int id;
    private int userId;
    private int courseId;
    private String role;

    public CourseParticipant(int id, int userId, int courseId, String role) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.role = role;
    }
    public CourseParticipant(){}

}
