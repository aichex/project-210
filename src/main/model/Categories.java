package model;

import java.util.ArrayList;

public class Categories {
    private String categoryName;
    private ArrayList<ToDoItem> n;

    public Categories(String name) {
        this.categoryName = name;
        this.n = new ArrayList<ToDoItem>();
    }

    //Getters:

    public String getCategoryName() {
        return categoryName;
    }

    //EFFECTS: add ToDoItem into category
    //MODIFIES: this
    public void addToDoItemInCategory(ToDoItem tdn) {
        n.add(tdn);
    }

    //EFFECTS: Change name of category
    //MODIFIES: this

    public void changeCategoryName(String name) {
        this.categoryName = name;
    }
}
