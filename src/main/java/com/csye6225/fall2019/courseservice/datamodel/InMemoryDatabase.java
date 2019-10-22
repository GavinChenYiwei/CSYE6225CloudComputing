package com.csye6225.fall2019.courseservice.datamodel;

import java.util.HashMap;

public class InMemoryDatabase {

    private static HashMap<Long, Professor> professorDB = new HashMap<Long, Professor>();

    public static HashMap<Long, Professor> getProfessorDB() {
        return professorDB;
    }
}
