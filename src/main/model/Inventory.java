package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;


public class Inventory implements Writable {
    private String name;
    private ArrayList<Categories> inv;

    //Inventory stores all Category class in an ArrayList

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
    //EFFECTS: Adds Category into Inventory given String
    public void addCategory(String name) {
        Categories c = new Categories(name);
        inv.add(c);
    }

    //MODIFIES: this
    //EFFECTS: Adds Category into Inventory given Category
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

    //EFFECTS: Returns Category Name in form of String, used by GUI
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


