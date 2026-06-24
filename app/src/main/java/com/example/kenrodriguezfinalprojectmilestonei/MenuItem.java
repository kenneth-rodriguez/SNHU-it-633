package com.example.kenrodriguezfinalprojectmilestonei;

/// Rubric: "The menu should have [...] categories [...] and include pictures, descriptions, and prices."
/// Rubric: Implicitly, caloric values should also be tracked.

// Create a reusable Menu Item object to streamline development a little bit.
public class MenuItem {
    // Best practices: private data modified through getters/setters.
    private String name;
    private String price;
    private String description;
    private String category;
    private int calories;
    private int imageID;

    // Constructor
    public MenuItem(String name, String price, String desc, String category, int cal, int image){
        this.name = name;
        this.price = price;
        this.description = desc;
        this.category = category;
        this.calories = cal;
        this.imageID = image;
    }

    // ACCESSORS/MUTATORS
    public String getName(){
        return name;
    }
    public String getPrice() {
        return price;
    }
    public String getDescription(){
        return description;
    }
    public String getCategory() { return category; }
    public int getCalories(){
        return calories;
    }
    public int getImageID(){
        return imageID;
    }
}

