package com.csye6225.fall2019.courseservice.service;

import com.csye6225.fall2019.courseservice.datamodel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentsService {
    static HashMap<Long, Student> std_Map = InMemoryDatabase.getStudentDB();

    public List<Student> getAllStudent() {
        ArrayList<Student> list = new ArrayList<>();
        for(Student student: std_Map.values()){
            list.add(student);
        }
        return list;
    }

    // Adding a Student
    public Student addStudent(String studentID, String firstName, String lastName, String joiningDate,
                              String department, List<String> courses) {
        // Next Id
        long nextAvailableId = std_Map.size() + 1;

        //Create a Student Object
        Student std = new Student(studentID, firstName, lastName, joiningDate, department, courses);
        std.setId(String.valueOf(nextAvailableId));
        std_Map.put(nextAvailableId, std);
        return std_Map.get(nextAvailableId);
    }

    // Updating Student Info
    public Student updateStudent(String stdId, Student std) {
        Student oldStdObject = std_Map.get(Long.valueOf(stdId));
        //Todo

        return oldStdObject;
    }

    // Deleting a Student
    public Student deleteStudent (Long stdId) {
        Student deletedStdDetails = std_Map.get(stdId);
        std_Map.remove(stdId);
        return deletedStdDetails;
    }
}
