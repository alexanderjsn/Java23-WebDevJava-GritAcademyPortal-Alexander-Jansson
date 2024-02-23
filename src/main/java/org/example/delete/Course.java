package org.example.delete;

public class Course {
    private int courseId;
    private String name;
    private int yhp;
    private String description;

    // Konstruktor
    public Course(int courseId, String name, int yhp, String description) {
        this.courseId = courseId;
        this.name = name;
        this.yhp = yhp;
        this.description = description;
    }

    public Course() {

    }

    // Getters och setters
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYhp() {
        return yhp;
    }

    public void setYhp(int yhp) {
        this.yhp = yhp;
    }

    public String getDescription(String getDescription) {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
