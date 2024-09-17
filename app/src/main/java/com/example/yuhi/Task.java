package com.example.yuhi;

public class Task {
    private String id;
    private String title;
    private String dateTime;

    public Task() {
        // Default constructor required for Firebase
    }

    public Task(String id, String title, String dateTime) {
        this.id = id;
        this.title = title;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}

