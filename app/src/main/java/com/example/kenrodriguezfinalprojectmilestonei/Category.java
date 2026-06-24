package com.example.kenrodriguezfinalprojectmilestonei;

import java.util.ArrayList;
import java.util.List;

// Create a reusable Category object to organize our Menu items in a modular fashion.
// That is, if a menu item has a category, create a new category. Should assist with scalability.
public class Category {
    public String name;
    public List<MenuItem> items;

    public Category(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }
}