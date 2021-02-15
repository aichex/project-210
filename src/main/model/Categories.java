package model;

import java.util.ArrayList;

public class Categories {
    private String categoryName;
    private ArrayList<ToDoItem> toDoItemList;

     //CONSTRUCTOR
    public Categories(String name) {
        this.categoryName = name;
        this.toDoItemList = new ArrayList<ToDoItem>();
    }

    //GETTERS
    public String getCategoryName() {
        return categoryName;
    }

    public int getListSize() {
        return toDoItemList.size();
    }

    public ArrayList<ToDoItem> getList() {
        return toDoItemList;
    }


    //EFFECTS: add ToDoItem into category
    //MODIFIES: this

    public void addToDoItemInCategory(ToDoItem tdn) {
        toDoItemList.add(tdn);
    }

    //EFFECTS: search for ToDoItem in list, if in list, return ToDoItem otherwise return null
    public ToDoItem searchForToDo(String name) {
        for (int i = 0; i < toDoItemList.size(); i++) {
            if (name.equals((toDoItemList.get(i)).getName())) {
                return toDoItemList.get(i);
            }
        }
        return null;
    }
    //EFFECTS: Searches for item, if item is in ToDoItem List, deleted ToDoItem
    //MODIFIES: this

    public void deleteToDo(String nam) {
        ToDoItem item = this.searchForToDo(nam);
        toDoItemList.remove(item);
    }


    //EFFECTS: Change name of category
    //MODIFIES: this

    public void changeName(String s) {
        this.categoryName = s;
    }

    //EFFECT: print out ToDoItem(s) in Category
    public void printCategory(ArrayList<ToDoItem> n) {
        for (int i = 0; i < n.size(); i++) {
            System.out.println(n.get(i).getName() + "-" + " " + n.get(i).getDate());
        }
    }
}
