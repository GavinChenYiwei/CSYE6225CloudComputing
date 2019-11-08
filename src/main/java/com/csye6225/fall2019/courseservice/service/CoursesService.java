package com.csye6225.fall2019.courseservice.service;

import com.csye6225.fall2019.courseservice.datamodel.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoursesService {
    static HashMap<Long, Course> cse_Map = InMemoryDatabase.getCourseDB();

    public List<Course> getAllCourse() {
        ArrayList<Course> list = new ArrayList<>();
        for(Course course: cse_Map.values()){
            list.add(course);
        }
        return list;
    }

    // Adding a Course
    public Course addCourse(String courseId, String professorId, String taId, String department, String boardId,
                            List<String> rosters, List<String> students) {
        // Next Id
        long nextAvailableId = cse_Map.size() + 1;

        //Create a Lecture Object
        Course cse = new Course(courseId, professorId, taId, department, boardId,
                rosters, students);
        cse.setId(String.valueOf(nextAvailableId));
        cse_Map.put(nextAvailableId, cse);
        return cse_Map.get(nextAvailableId);
    }

    // Updating Course Info
    public Course updateCourse(String cseId, Course cse) {
        Course oldCseObject = cse_Map.get(Long.valueOf(cseId));
        // Todo

        return oldCseObject;
    }

    // Deleting a Course
    public Course deleteCourse (Long cseId) {
        Course deletedCseDetails = cse_Map.get(cseId);
        cse_Map.remove(cseId);
        return deletedCseDetails;
    }
}
