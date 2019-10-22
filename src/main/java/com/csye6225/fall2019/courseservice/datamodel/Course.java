package com.csye6225.fall2019.courseservice.datamodel;

import java.util.List;

public class Course {

    private String name;
    private List<Lecture> lectures;
    private String board;
    private List<Student> roster;
    private List<Student> enrolledStd;
    private Professor professor;
    private Student teachAssist;

    public Course() {
    }

    public Course(String name, List<Lecture> lectures, String board, List<Student> roster, List<Student> enrolledStd,
                  Professor professor, Student teachAssist) {
        this.name = name;
        this.lectures = lectures;
        this.board = board;
        this.roster = roster;
        this.enrolledStd = enrolledStd;
        this.professor = professor;
        this.teachAssist = teachAssist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public List<Student> getRoster() {
        return roster;
    }

    public void setRoster(List<Student> roster) {
        this.roster = roster;
    }

    public List<Student> getEnrolledStd() {
        return enrolledStd;
    }

    public void setEnrolledStd(List<Student> enrolledStd) {
        this.enrolledStd = enrolledStd;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Student getTeachAssist() {
        return teachAssist;
    }

    public void setTeachAssist(Student teachAssist) {
        this.teachAssist = teachAssist;
    }
}
