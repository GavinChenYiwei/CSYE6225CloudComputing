package com.csye6225.fall2019.courseservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.csye6225.fall2019.courseservice.datamodel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoursesService {
    static DynamoDbConnector dynamoDb;
    DynamoDBMapper mapper;

    public CoursesService(){
        dynamoDb = new DynamoDbConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    public List<Course> getAllCourse() {
        ArrayList<Course> list = new ArrayList<>();
        PaginatedScanList<Course> cseList = mapper.scan(Course.class, new DynamoDBScanExpression());
        for(Course course: cseList){
            list.add(course);
        }
        return list;
    }

    public Course addCourse(Course course){
        mapper.save(course);
        return course;
    }

    // Updating Course Info
    public Course updateCourse(String cseId, Course cse) {
        Course oldCseObject = mapper.load(Course.class, cseId);
        oldCseObject.setBoardId(cse.getBoardId());
        oldCseObject.setCourseId(cse.getCourseId());
        oldCseObject.setDepartment(cse.getDepartment());
        oldCseObject.setListOfRegisteredroster(cse.getListOfRegisteredroster());
        oldCseObject.setListOfRegisteredStudents(cse.getListOfRegisteredStudents());
        oldCseObject.setTaId(cse.getTaId());
        oldCseObject.setProfessorId(cse.getProfessorId());
        return oldCseObject;
    }

    // Deleting a Course
    public Course deleteCourse (String cseId) {
        Course deletedCseDetails = mapper.load(Course.class, cseId);
        mapper.delete(deletedCseDetails);
        return deletedCseDetails;
    }
}
