package com.example.kenrodriguezfinalprojectmilestonei;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// "Helper" class to assist in creating menu item pages for our menu items.
// Should serve to make development a little leaner and more scalable (I do not want to make a page for every item)
public class ItemDetails extends AppCompatActivity {

    // Switch contexts from the "main" Menu to the long-pressed menu item page.
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // Switch to the menu item page
        setContentView(R.layout.menu_item_page);

        // Fix the toolbar on top
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Take the intent passed through on the MainActivity class, then create a page based on that.
        // In addition to getting name/price/description/calories/imageID,
        String name = getIntent().getStringExtra("itemName");
        String price = getIntent().getStringExtra("itemPrice");
        String description = getIntent().getStringExtra("itemDescription");
        int calories = getIntent().getIntExtra("itemCalories", 0);
        int itemImage = getIntent().getIntExtra("itemImage", android.R.drawable.ic_menu_gallery);

        // "Grab" our UI elements
        ImageView menuItemImage = findViewById(R.id.menuItemImage);
        TextView menuItemName = findViewById(R.id.menuItemName);
        TextView menuItemPrice = findViewById(R.id.menuItemPrice);
        TextView menuItemCalories = findViewById(R.id.menuItemCalories);
        TextView menuItemDescription = findViewById(R.id.menuItemDescription);

        // Update UI elements with the data passed through our intent
        menuItemImage.setImageResource(itemImage);
        menuItemName.setText(name);
        menuItemPrice.setText(price);
        menuItemDescription.setText(description);
        menuItemCalories.setText(getString(R.string.calorie_count, calories));
    }
}
