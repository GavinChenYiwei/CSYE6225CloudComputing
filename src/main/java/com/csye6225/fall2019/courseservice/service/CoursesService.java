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
    public Course addCourse(String name, List<Lecture> lectures, String board, List<Student> roster,
                            List<Student> enrolledStd,Professor professor, Student teachAssist) {
        // Next Id
        long nextAvailableId = cse_Map.size() + 1;

        //Create a Lecture Object
        Course cse = new Course(name, lectures, board, roster, enrolledStd, professor, teachAssist);
        cse.setId(String.valueOf(nextAvailableId));
        cse_Map.put(nextAvailableId, cse);
        return cse_Map.get(nextAvailableId);
    }

    // Updating Professor Info
    public Course updateCourse(String cseId, Course cse) {
        Course oldCseObject = cse_Map.get(Long.valueOf(cseId));
        oldCseObject.setBoard(cse.getBoard());
        oldCseObject.setEnrolledStd(cse.getEnrolledStd());
        oldCseObject.setLectures(cse.getLectures());
        oldCseObject.setName(cse.getName());
        oldCseObject.setRoster(cse.getRoster());
        oldCseObject.setTeachAssist(oldCseObject.getTeachAssist());
        oldCseObject.setProfessor(cse.getProfessor());
        return oldCseObject;
    }

    // Deleting a Lecture
    public Course deleteCourse (Long cseId) {
        Course deletedCseDetails = cse_Map.get(cseId);
        cse_Map.remove(cseId);
        return deletedCseDetails;
    }
}
