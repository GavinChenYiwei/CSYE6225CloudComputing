package com.csye6225.fall2019.courseservice.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.csye6225.fall2019.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.fall2019.courseservice.datamodel.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProfessorsService {
    static DynamoDbConnector dynamoDb;
    DynamoDBMapper mapper;

    public ProfessorsService() {
        dynamoDb = new DynamoDbConnector();
        dynamoDb.init();
        mapper = new DynamoDBMapper(dynamoDb.getClient());
    }

    // Getting a list of all professor
    // GET "..webapi/professors"

    public ArrayList<Professor> getAllProfessors() {
        //Getting the list
        ArrayList<Professor> list = new ArrayList<Professor>();
        PaginatedScanList<Professor> profList = mapper.scan(Professor.class, new DynamoDBScanExpression());
        for (Professor prof : profList) {
            list.add(prof);
        }
        return list ;
    }

    public Professor addProfessor(Professor prof) {
        mapper.save(prof);
        return prof;
    }

    // Getting One Professor
    public Professor getProfessor(String profId) {
        Professor prof2 = mapper.load(Professor.class, profId);
        System.out.println("Item retrieved:");
        System.out.println(prof2.toString());
        return prof2;
    }

    // Deleting a professor
    public Professor deleteProfessor(String profId) {
        Professor deletedProfDetails = mapper.load(Professor.class, profId);
        mapper.delete(deletedProfDetails);
        return deletedProfDetails;
    }

    // Updating Professor Info
    public Professor updateProfessorInformation(String profId, Professor prof) {
        Professor oldProfObject = mapper.load(Professor.class, profId);
        oldProfObject.setFirstName(prof.getFirstName());
        oldProfObject.setLastName(prof.getLastName());
        oldProfObject.setProfessorId(prof.getFirstName()+prof.getLastName());
        oldProfObject.setJoiningDate(prof.getJoiningDate());
        oldProfObject.setDepartment(prof.getDepartment());
        mapper.save(oldProfObject);
        return prof;
    }

    // Get professors in a department
    public ArrayList<Professor> getProfessorsByDepartment(String department) {
        //Getting the list
        ArrayList<Professor> list = new ArrayList<Professor>();
        Map<String, AttributeValue> scanMap = new HashMap<>();
        scanMap.put(":department", new AttributeValue().withS(department));
        DynamoDBScanExpression expression = new DynamoDBScanExpression()
                .withFilterExpression("department = :department").withExpressionAttributeValues(scanMap);
        PaginatedScanList<Professor> scanList = mapper.scan(Professor.class, expression);
        for (Professor prof : scanList) {
            list.add(prof);
        }
        return list;
    }

    // Get professors for a year with a size limit
}
