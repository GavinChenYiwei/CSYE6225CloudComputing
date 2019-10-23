package com.csye6225.fall2019.courseservice.datamodel;

public class Lecture {

    private String id;
    private String note;
    private String material;

    public Lecture() {
    }

    public Lecture(String note, String material) {
        this.note = note;
        this.material = material;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
