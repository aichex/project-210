package model;


public class ToDoItem {
    //Fields
    private String itemName;
    private String status;
    private String date;
    private double cost;

    //TODOItem is a task entry that will have a status- pending/complete name and date in format MM/DD/YY

    //Constructor
    public ToDoItem(String name) {
        this.itemName = name;
        this.status = "";
        this.date = "";
        this.cost = 0.00;
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

    public double getCost() {
        return this.cost;
    }

    //MODIFIES: this
    //EFFECT: Changes status of item to completed
    public void statusCompleted() {
        this.status = "completed";
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

    //EFFECT: Set cost of ToDoItem
    //MODIFIES: this
    public void setCost(double n) {
        this.cost = n;
    }
}
