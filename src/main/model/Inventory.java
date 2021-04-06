package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory implements Writable {
    private String name;
    private ArrayList<Categories> inv;

    //Constructor

    public Inventory(String name) {

        this.inv = new ArrayList<Categories>();
        this.name = name;
    }

    //Getters:

    public ArrayList<Categories> getCategories() {
        return inv;
    }


    //MODIFIES: this
    //Adds Category into Inventory
    public void addCategory(String name) {
        Categories c = new Categories(name);
        inv.add(c);
    }

    public void addCategory(Categories c) {
        inv.add(c);
    }

    //EFFECTS: Search for Category in Inventory, if not found return null
    public Categories searchForCategory(String name) {
        for (int i = 0; i < inv.size(); i++) {
            if (name.equals((inv.get(i)).getCategoryName())) {
                return inv.get(i);
            }
        }
        return null;
    }


    public String getCategoryNames(ArrayList<Categories> n) {
        String name = "";
        for (int i = 0; i < n.size(); i++) {
         name += n.get(i).getCategoryName();
        }
        return name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("category", categoriesToJson());
        return json;
    }

    //EFFECTS: returns Categories in Inventory as JSON array
    private JSONArray categoriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Categories c : inv) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }
}


