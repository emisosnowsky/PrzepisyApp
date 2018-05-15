package com.example.przepisyweb.models;

public class Recipe {

    String title;
    String description;
    String image;

    public Recipe(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public Recipe() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
