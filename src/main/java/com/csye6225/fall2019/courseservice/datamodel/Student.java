package com.csye6225.fall2019.courseservice.datamodel;

import java.util.List;

public class Student {
    private String id;
    private String studentId;
    private String firstName;
    private String lastName;
    private String joiningDate;
    private String department;
    private List<String> registeredCourses;

    public Student(){}

    public Student(String studentId, String firstName, String lastName, String joiningDate,
                   String department, List<String> registeredCourses) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.joiningDate = joiningDate;
        this.department = department;
        this.registeredCourses = registeredCourses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<String> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }
}
