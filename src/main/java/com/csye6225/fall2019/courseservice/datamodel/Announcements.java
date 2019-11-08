package com.csye6225.fall2019.courseservice.datamodel;

public class Announcements {
    private String id;
    private String announcementId;
    private String announcementText;
    private String boardId;

    public Announcements(){}

    public Announcements(String id, String announcementId, String announcementText, String boardId) {
        this.id = id;
        this.announcementId = announcementId;
        this.announcementText = announcementText;
        this.boardId = boardId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementText() {
        return announcementText;
    }

    public void setAnnouncementText(String announcementText) {
        this.announcementText = announcementText;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }
}
