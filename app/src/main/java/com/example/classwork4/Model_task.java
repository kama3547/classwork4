package com.example.classwork4;

public class Model_task {
    private String title;
    private String description;

    public Model_task(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Model_task(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
