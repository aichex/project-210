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

    //EFFECTS: add ToDoItem into category
    //MODIFIES: this
    public void addToDoItemInCategory(ToDoItem tdn) {
        toDoItemList.add(tdn);
    }

    public void removeToDo(ToDoItem t) {
        if (t.getStatus() == "completed") {
            toDoItemList.remove(t);
            completeItemList.add(t);
        }
    }

    public void deleteToDo(ToDoItem t) {
        if(toDoItemList.contains(t)) {
        toDoItemList.remove(t);
    }

    //EFFECTS: Change name of category
    //MODIFIES: this
        public void changeName(String s) {
            this.categoryName = s;
        }

    //EFFECT: print out ToDoItem(s) in Category

    public void printCategory(ArrayList<ToDoItem> n) {
        for (int i = 0; i < n.size(); i++) {
            System.out.println(n.get(i).getName() + "-" + n.get(i).getDate());
        }
    }
}
