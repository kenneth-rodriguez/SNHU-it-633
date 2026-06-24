package com.example.kenrodriguezfinalprojectmilestonei;


import java.util.ArrayList;
import java.util.List;

// A "helper" object to populate our menu with items and keep the MainActivity class "clean."
public class PopulateMenu {
    // Create a list of menu items to pass through to our main class.
    public static List<MenuItem> getMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();

        ///  Quick Reference: MenuItem(String name, String price, String desc, String category, int cal, int image)
        // Appetizers
        menuItems.add(new MenuItem("Mozzarella Sticks", "$6.00", "Fried mozzarella sticks covered in a bread crumb coating and served with a marinara sauce!", "Appetizers", 400, R.drawable.a1));
        menuItems.add(new MenuItem("Chicken Wings", "$8.00", "Fried chicken wings coated in your choice of garlic parmesan, barbecue, or buffalo sauces!", "Appetizers", 800, R.drawable.a2));
        menuItems.add(new MenuItem("Onion Rings", "$5.00", "Lightly battered onion rings stacked high and served with our signature house sauce!", "Appetizers", 500, R.drawable.a3));
        menuItems.add(new MenuItem("Cheese Curds", "$6.00", "Wisconsin cheese curds fried to perfection with a tempura batter and served with buffalo sauce and ranch!", "Appetizers", 600, R.drawable.a4));
        menuItems.add(new MenuItem("Quesadillas", "$8.00", "Chicken-filled quesadilla quarters for the table, served with our award winning salsa!", "Appetizers", 500, R.drawable.a5));

        // Entrees
        menuItems.add(new MenuItem("Double Cheeseburger", "$10.00", "An all-American classic served with lettuce, tomato, onion, a side of fries, and your choice of sauces!","Entrees", 1000, R.drawable.a6));
        menuItems.add(new MenuItem("Large Pizza", "$15.00", "A pizza cooked to perfection in our wood fired ovens, made from hand-rolled dough and your seletion of toppings!", "Entrees", 1000, R.drawable.a7));
        menuItems.add(new MenuItem("Chicken Sandwich", "$10.00", "Try our award-winning Southern fried chicken sandwich! Served with pickles, lettuce, sauces of your choice, and a side of fries!", "Entrees", 1000, R.drawable.a8));
        menuItems.add(new MenuItem("Fish and Chips", "$9.00", "Hand battered and deep fried Atlantic cod, served with a side of our signature hand-cut fries, tartar sauce, and malt vinegar!", "Entrees", 1000, R.drawable.a9));
        menuItems.add(new MenuItem("Veggie Wrap", "$10.00", "A fresh and crisp wrap served with Vegan-friendly lettuce, tomato, and seasonal vegetables! Please ask for what's fresh!", "Entrees", 1000, R.drawable.a10));

        // Desserts
        menuItems.add(new MenuItem("Loaded Brownie", "$7.00", "A piping hot house brownie served a la mode!", "Desserts", 800, R.drawable.a11));
        menuItems.add(new MenuItem("Ice Cream Sandwich", "$7.00", "Our iconic handmade chocolate chip cookies sandwiching Bramble Farms vanilla ice cream!", "Desserts", 800, R.drawable.a12));
        menuItems.add(new MenuItem("Tres Leches Cake", "$6.00", "A deliciously moist and massive slice of our award-winning tres leches cake!", "Desserts", 800, R.drawable.a13));
        menuItems.add(new MenuItem("Seasonal Pie", "$6.00", "A slice of our seasonal pie served a la mode! Ask your server to see what we've got ready to eat!", "Desserts", 800, R.drawable.a14));
        menuItems.add(new MenuItem("Pile o' Donuts", "$8.00", "Five of our iconic glazed yeast donuts!", "Desserts", 900, R.drawable.a15));

        // Drinks
        menuItems.add(new MenuItem("Caramel-colored Cola", "$1.00", "Our iconic store-brand caramel-colored cola!", "Drinks", 200, R.drawable.a16));
        menuItems.add(new MenuItem("Loaded Chocolate Milk", "$6.00", "Our house specialty chocolate milk, loaded with whipped cream, cookies, sprinkles, and more!", "Drinks", 1000, R.drawable.a17));
        menuItems.add(new MenuItem("Coffee", "$2.00", "Artisan Arabica coffee served with cream, sugar, and an optional shot of espresso!", "Drinks", 10, R.drawable.a18));
        menuItems.add(new MenuItem("Orange Juice", "$2.00", "Our hand-squeezed orange juice utilizing the finest Peruvian oranges on the market!", "Drinks", 300, R.drawable.a19));
        menuItems.add(new MenuItem("Water", "$0.00", "The most sensible thing on our menu!", "Drinks", 0, R.drawable.a20));

        return menuItems;
    }
}
