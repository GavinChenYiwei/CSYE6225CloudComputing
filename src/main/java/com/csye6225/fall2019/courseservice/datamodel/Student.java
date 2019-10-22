package com.csye6225.fall2019.courseservice.datamodel;

import java.util.List;

public class Student {
    private String name;
    private String studentID;
    private String image;
    private List<Course> enrolledCourse;
    private Program program;

    public Student(){}

    public Student(String name, String studentID, String image, List<Course> enrolledCourse, Program program) {
        this.name = name;
        this.studentID = studentID;
        this.image = image;
        this.enrolledCourse = enrolledCourse;
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Course> getEnrolledCourse() {
        return enrolledCourse;
    }

    public void setEnrolledCourse(List<Course> enrolledCourse) {
        this.enrolledCourse = enrolledCourse;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
