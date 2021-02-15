package model;

import com.sun.tools.javac.comp.Todo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private ArrayList<Categories> currentToDoItem;


    // Constructor
   //EFFECTS Creates a list for ToDoItem sorted in completed and not-completed lists
    public Inventory() {
        currentToDoItem = new ArrayList<Categories>();
    }


    public void addCategoryToInventory(String name) {
        Categories s = new Categories(name);
    }


    public void printAllCategories(ArrayList<Categories> categories) {
        for (int i = 0; i < categories.size(); i++) {
            System.out.print(categories.get(i));
        }
    }
}
