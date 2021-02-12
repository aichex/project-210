package model;

import com.sun.tools.javac.comp.Todo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    private ArrayList<ArrayList<ToDoItem>> currentToDoItem;



    // Constructor
//EFFECTS Creates a list for ToDoItem sorted in completed and not-compeleted lists
    public Inventory() {
        currentToDoItem = new ArrayList<ToDoItem>();

    }



    public ArrayList<ToDoItem> displayCurrentToDoList() {
        return currentToDoItem;
    }


    public void removeToDo(ToDoItem t) {
        if (t.getName() == "completed") {
            currentToDoItem.remove(t);
        }
    }

    //EFFECT: Display all categories in list
    public void displayCategories(){
        return currentToDoItem;
    }
}

