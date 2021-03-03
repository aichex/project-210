package model;

import Exceptions.AlreadyExists;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Categories> inv;

    //Constructor

    public Inventory() {
        this.inv = new ArrayList<Categories>();
    }

    //Getters:

    public ArrayList<Categories> getCategories() {
        return inv;
    }

    public void addCategory(String name) {
        Categories c = new Categories(name);
        inv.add(c);
    }

    public Categories searchForCategory(String name) {
        for (int i = 0; i < inv.size(); i++) {
            if (name.equals((inv.get(i)).getCategoryName())) {
                return inv.get(i);
            }
        }
        return null;
    }

    //EFFECTS: Print all categories in Inventory
    public void printAllCategory(ArrayList<Categories> n) {
        for (int i = 0; i < n.size(); i++) {
            System.out.println(n.get(i).getCategoryName());
        }
    }
}


