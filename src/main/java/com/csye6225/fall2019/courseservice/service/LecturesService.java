package com.csye6225.fall2019.courseservice.service;

import com.csye6225.fall2019.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.fall2019.courseservice.datamodel.Lecture;
import com.csye6225.fall2019.courseservice.datamodel.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LecturesService {
    static HashMap<Long, Lecture> lec_Map = InMemoryDatabase.getLectureDB();

    public List<Lecture> getAllLectures() {
        ArrayList<Lecture> list = new ArrayList<>();
        for(Lecture lecture: lec_Map.values()){
            list.add(lecture);
        }
        return list;
    }

    // Adding a Lecture
    public Lecture addLecture(String note, String material) {
        // Next Id
        long nextAvailableId = lec_Map.size() + 1;

        //Create a Lecture Object
        Lecture lec = new Lecture(note, material);
        lec.setId(String.valueOf(nextAvailableId));
        lec_Map.put(nextAvailableId, lec);
        return lec_Map.get(nextAvailableId);
    }

    // Updating Professor Info
    public Lecture updateLecture(String lecId, Lecture lec) {
        Lecture oldLecObject = lec_Map.get(Long.valueOf(lecId));
        oldLecObject.setMaterial(lec.getMaterial());
        oldLecObject.setNote(lec.getNote());
        return oldLecObject;
    }

    // Deleting a Lecture
    public Lecture deleteLecture (Long lecId) {
        Lecture deletedLecDetails = lec_Map.get(lecId);
        lec_Map.remove(lecId);
        return deletedLecDetails;
    }
}
