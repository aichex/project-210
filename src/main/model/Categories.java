package model;

import java.util.ArrayList;

public class Categories {
    private String categoryName;
    private ArrayList<ToDoItem> toDoItemList;
    private ArrayList<ToDoItem> completeItemList;

    public Categories(String name) {
        this.categoryName = name;
        this.toDoItemList = new ArrayList<ToDoItem>();
        this.completeItemList = new ArrayList<ToDoItem>();
    }

    //Getters:

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

    public boolean searchForToDo(String name) {
        for (int i = 0; i < toDoItemList.size(); i++) {
            if (name.equals((toDoItemList.get(i)).getName())) {
                return true;
            }
        }
        return false;
    }

    public void deleteToDo(String nam) {
        for (int i = 0; i < toDoItemList.size(); i++) {
            if (nam.equals((toDoItemList.get(i).getName()))) {
                toDoItemList.remove(i);
            }
        }
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
