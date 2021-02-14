package model;

import java.util.ArrayList;
import java.util.List;

public class ToDoItem {
    //Fields
    private String itemName;
    private String status;
    private double cost;
    private String date;


    //Constructor
    public ToDoItem(String name) {
        this.itemName = name;
        this.status = "";
        this.cost = 0;
        this.date = "";
    }

    //Getters

    public String getStatus() {
        return status;
    }

    public String getName() {
        return itemName;
    }

    public String getDate() {
        return this.date;
    }

    //MODIFIES: this
    //EFFECT: Changes status of item to completed
    public void statusCompleted() {
        this.status = "completed";
    }

    //MODIFIES: this
    //EFFECT: Changes status of item to pending
    public void statusPending() {
        this.status = "pending";
    }

    //EFFECTS: Rename ToDoItem
    // MODIFIES this

    public void changeName(String name) {
        this.itemName = name;
    }

    //EFFECT: Set date in xx/xx/xx format
    //MODIFIES: this
    public void setDate(String date) {
        this.date = date;
    }
}
