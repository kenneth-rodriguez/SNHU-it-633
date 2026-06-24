package com.example.kenrodriguezfinalprojectmilestonei;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Category> data;

    public MenuListAdapter(Context context, List<MenuItem> menuList) {
        this.context = context;
        this.data = new ArrayList<>();

        // If menu isn't empty:
        if (menuList != null) {
            for (MenuItem item : menuList) {
                Category targetCategory = null;

                // Check if we already created a Category for this tag
                for (Category c : data) {
                    if (c.name.equals(item.getCategory())) {
                        targetCategory = c;
                        break;
                    }
                }

                // If category not found, create a new one and add it to our list of categories
                if (targetCategory == null) {
                    targetCategory = new Category(item.getCategory());
                    data.add(targetCategory);
                }

                // Add the item to that specific category
                targetCategory.items.add(item);
            }
        }
    }


    /// Accessors and Mutators and other ListView things that are necessary for operation.
    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return data.get(groupPosition).items.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return data.get(groupPosition).name;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return data.get(groupPosition).items.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_category, parent, false);
        }
        TextView lblListHeader = convertView.findViewById(R.id.textViewCategory);
        lblListHeader.setText(headerTitle);
        return convertView;
    }

    // Create item "cards" for the list view, drawing each item's image, name, and price.
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        MenuItem menuItem = (MenuItem) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView imgItem = convertView.findViewById(R.id.itemImage);
        TextView txtName = convertView.findViewById(R.id.itemName);
        TextView txtPrice = convertView.findViewById(R.id.itemPrice);

        if (menuItem != null) {
            imgItem.setImageResource(menuItem.getImageID());
            txtName.setText(menuItem.getName());
            txtPrice.setText(menuItem.getPrice());
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
