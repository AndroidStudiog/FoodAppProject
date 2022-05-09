package com.example.foodappproject.models;

public class PopularHorModel {
    int image;
    String description;
    String name;

    public PopularHorModel(int image, String description, String name) {
        this.image = image;
        this.description = description;
        this.name = name;
    }


    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
