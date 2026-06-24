package com.example.kenrodriguezfinalprojectmilestonei;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // Get our UI elements and create a list for our menu items
    ExpandableListView menuListView;
    MenuListAdapter menuListAdapter;
    List<MenuItem> menuItems;

    // Track calorie count, assign that to a string, and set a reset button
    int currCalories = 0;
    TextView textCalorieCount;
    android.widget.Button resetCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Set up Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Hook our UI elements
        menuListView = findViewById(R.id.menuListView);
        textCalorieCount = findViewById(R.id.textViewCalorieCount);
        resetCalories = findViewById(R.id.resetCalories);

        // Reset the calorie counter on button press
        resetCalories.setOnClickListener(v -> {
            currCalories = 0;
            textCalorieCount.setText(getString(R.string.calorie_count, currCalories));
            // Inform user that calorie count has been reset w/ toast notification
            Toast.makeText(MainActivity.this, "Calorie Counter Reset", Toast.LENGTH_SHORT).show();
        });

        // Populate Menu List using the PopulateMenu "helper" class
        menuItems = PopulateMenu.getMenuItems();

        // Add menu list items to our UI element
        menuListAdapter = new MenuListAdapter(this, menuItems);
        menuListView.setAdapter(menuListAdapter);


        /// Rubric: Go to page with item's picture, name, price, and description.
        /// ON SHORT PRESS of menu item: go to menu item's item page.
        menuListView.setOnChildClickListener((parent, view, groupPosition, childPosition, id) -> {
            // Grab our menu item based on its position in the list
            MenuItem item =(MenuItem) menuListAdapter.getChild(groupPosition, childPosition);

            // Create our menu item page based on the MenuItem's characteristics (Picture/name/price/etc.)
            // as outlined in the MenuItem class.
            Intent intent = new Intent(MainActivity.this, ItemDetails.class);
            intent.putExtra("itemName", item.getName());
            intent.putExtra("itemPrice", item.getPrice());
            intent.putExtra("itemDescription", item.getDescription());
            intent.putExtra("itemCalories", item.getCalories());
            intent.putExtra("itemImage", item.getImageID());
            startActivity(intent);
            return true;
        });

        /// Rubric: Create a calorie counter based on items selected from the menu
        // ON LONG PRESS of menu item: add its caloric value to the calorie counter.
        menuListView.setOnItemLongClickListener((parent, view, position, id) -> {
            // Check that the long pressed item isn't a category dropdown and is instead a child
            if (ExpandableListView.getPackedPositionType(id) == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
                // Get item's position based on its ID number in the list
                int positionInGroup = ExpandableListView.getPackedPositionGroup(id);
                int positionOfChild = ExpandableListView.getPackedPositionChild(id);

                // Get the item at the long pressed position, then add its caloric value to the calorie counter.
                MenuItem selectedItem =(MenuItem) menuListAdapter.getChild(positionInGroup, positionOfChild);
                currCalories += selectedItem.getCalories();

                // Convert current calorie value to a string, then update the calorie counter's UI to match.
                textCalorieCount.setText(getString(R.string.calorie_count, currCalories));

                // Inform the user that the calorie counter's been updated with a toast notification
                Toast.makeText(MainActivity.this,
                        getString(R.string.calories_added_notif),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
    }


}