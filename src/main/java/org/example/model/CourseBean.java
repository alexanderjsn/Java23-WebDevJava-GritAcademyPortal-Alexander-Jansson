package org.example.model;

import java.io.Serializable;

public class CourseBean implements Serializable {

    private int id;
    private String name;

    private int YHP;
    private String description;

    public CourseBean(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYHP() {
        return YHP;
    }

    public void setYHP(int YHP) {
        this.YHP = YHP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
