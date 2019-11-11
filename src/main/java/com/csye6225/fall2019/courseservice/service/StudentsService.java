package com.csye6225.fall2019.courseservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.csye6225.fall2019.courseservice.datamodel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentsService {
    static DynamoDbConnector dynamoDb;
    DynamoDBMapper mapper;

    public StudentsService(){
        dynamoDb = new DynamoDbConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public List<Student> getAllStudent() {
        ArrayList<Student> list = new ArrayList<>();
        PaginatedScanList<Student> stdList = mapper.scan(Student.class, new DynamoDBScanExpression());
        for(Student student: stdList){
            list.add(student);
        }
        return list;
    }

    // Adding a Student
    public Student addStudent(Student std) {
        mapper.save(std);
        return std;
    }

    // Updating Student Info
    public Student updateStudent(String stdId, Student std) {
        Student oldStdObject = mapper.load(Student.class, stdId);
        oldStdObject.setFirstName(std.getFirstName());
        oldStdObject.setLastName(std.getLastName());
        oldStdObject.setStudentId(oldStdObject.getFirstName()+oldStdObject.getLastName());
        oldStdObject.setJoiningDate(std.getJoiningDate());
        oldStdObject.setDepartment(std.getDepartment());
        oldStdObject.setRegisteredCourses(std.getRegisteredCourses());
        mapper.save(oldStdObject);
        return oldStdObject;
    }

    // Deleting a Student
    public Student deleteStudent (String stdId) {
        Student deletedStdDetails = mapper.load(Student.class, stdId);
        mapper.delete(deletedStdDetails);
        return deletedStdDetails;
    }
}
