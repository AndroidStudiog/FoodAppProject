package com.example.foodappproject.models;

public class DetailedDailyMealModel {
    int image;
    String name;
    String description;
    String rating;
    String timing;
    String price;
    String add_to_cart;

    public DetailedDailyMealModel(int image, String name, String description, String rating, String timing, String price, String add_to_cart) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.timing = timing;
        this.price = price;
        this.add_to_cart = add_to_cart;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAdd_to_cart() {
        return add_to_cart;
    }

    public void setAdd_to_cart(String add_to_cart) {
        this.add_to_cart = add_to_cart;
    }
}