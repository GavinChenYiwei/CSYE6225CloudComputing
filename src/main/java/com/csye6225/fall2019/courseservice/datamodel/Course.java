package com.csye6225.fall2019.courseservice.datamodel;

import java.util.List;

public class Course {

    private String id;
    private String courseId;
    private String professorId;
    private String taId;
    private String department;
    private String boardId;
    private List<String> listOfRegisteredroster;
    private List<String> listOfRegisteredStudents;

    public Course() {
    }

    public Course(String courseId, String professorId, String taId, String department, String boardId,
                  List<String> listOfRegisteredroster, List<String> listOfRegisteredStudents) {
        this.courseId = courseId;
        this.professorId = professorId;
        this.taId = taId;
        this.department = department;
        this.boardId = boardId;
        this.listOfRegisteredroster = listOfRegisteredroster;
        this.listOfRegisteredStudents = listOfRegisteredStudents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getTaId() {
        return taId;
    }

    public void setTaId(String taId) {
        this.taId = taId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public List<String> getListOfRegisteredroster() {
        return listOfRegisteredroster;
    }

    public void setListOfRegisteredroster(List<String> listOfRegisteredroster) {
        this.listOfRegisteredroster = listOfRegisteredroster;
    }

    public List<String> getListOfRegisteredStudents() {
        return listOfRegisteredStudents;
    }

    public void setListOfRegisteredStudents(List<String> listOfRegisteredStudents) {
        this.listOfRegisteredStudents = listOfRegisteredStudents;
    }
}
