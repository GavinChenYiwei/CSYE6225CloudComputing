package com.csye6225.fall2019.courseservice.service;


//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
//import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
//import com.csye6225.fall2019.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.fall2019.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.fall2019.courseservice.datamodel.Professor;

import javax.ws.rs.ApplicationPath;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ProfessorsService {
    static HashMap<Long, Professor> prof_Map = InMemoryDatabase.getProfessorDB();

    public ProfessorsService() {
    }

    // Getting a list of all professor
    // GET "..webapi/professors"

    public ArrayList<Professor> getAllProfessors() {
        //Getting the list
        ArrayList<Professor> list = new ArrayList<Professor>();
        for (Professor prof : prof_Map.values()) {
            list.add(prof);
        }
        return list ;
    }

    // Adding a professor
    public Professor addProfessor(String firstName, String lastName, String department, Date joiningDate) {
        // Next Id
        long nextAvailableId = prof_Map.size() + 1;

        //Create a Professor Object
        Professor prof = new Professor(firstName+lastName, firstName , lastName,
                department, joiningDate.toString());

        prof_Map.put(nextAvailableId, prof);

        return prof_Map.get(nextAvailableId);
    }


    // Getting One Professor
    public Professor getProfessor(String profId) {

        //Simple HashKey Load
        Professor prof2 = prof_Map.get(profId);
        System.out.println("Item retrieved:");
        System.out.println(prof2.toString());

        return prof2;
    }

    // Deleting a professor
    public Professor deleteProfessor(Long profId) {
        Professor deletedProfDetails = prof_Map.get(profId);
        prof_Map.remove(profId);
        return deletedProfDetails;
    }

    // Updating Professor Info
    public Professor updateProfessorInformation(String profId, Professor prof) {
        Professor oldProfObject = prof_Map.get(profId);
        profId = oldProfObject.getProfessorId();
        prof.setProfessorId(profId);
        return prof;
    }

    // Get professors in a department
    public ArrayList<Professor> getProfessorsByDepartment(String department) {
        //Getting the list
        ArrayList<Professor> list = new ArrayList<Professor>();
        for (Professor prof : prof_Map.values()) {
            if (prof.getDepartment().equals(department)) {
                list.add(prof);
            }
        }
        return list;
    }

    // Get professors for a year with a size limit
}
