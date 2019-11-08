package com.csye6225.fall2019.courseservice.datamodel;

import java.util.HashMap;

public class InMemoryDatabase {

    private static HashMap<Long, Professor> professorDB = new HashMap<Long, Professor>();
    private static HashMap<Long, Course> courseDB = new HashMap<>();
    private static HashMap<Long, Student> studentDB = new HashMap<>();

    public static HashMap<Long, Professor> getProfessorDB() {
        return professorDB;
    }

    public static HashMap<Long, Course> getCourseDB() {
        return courseDB;
    }

    public static HashMap<Long, Student> getStudentDB() {
        return studentDB;
    }
}
