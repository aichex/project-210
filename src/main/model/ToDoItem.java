package model;


import org.json.JSONObject;
import persistence.Writable;


//TODOItem is a task entry that will have a status- pending/complete, name and date in format MM/DD/YY

public class ToDoItem implements Writable {

    private String itemName;
    private String status;
    private String date;
    private double cost;

    //Constructor
    public ToDoItem(String name) {
        this.itemName = name;
        this.status = "";
        this.date = "01/01/21";
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", itemName);
        json.put("status", status);
        json.put("date", date);
        json.put("cost", cost);
        return json;
    }
}
