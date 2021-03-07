package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class Completed extends Categories implements Writable {
    private ArrayList<ToDoItem> completedList;

    public Completed(String name) {
        super(name);
        this.completedList = new ArrayList<ToDoItem>();
    }

    //EFFECTS: add ToDoItem in Completed list
    public void addToCompletedList(ToDoItem tdn) {
        completedList.add(tdn);
    }

    //EFFECTS: remove ToDoItem in Completed list
    public void removeFromCompletedList(ToDoItem tdn) {
        completedList.remove(tdn);
    }

    @Override
    public JSONObject toJson() {
        return null;
    }
}
