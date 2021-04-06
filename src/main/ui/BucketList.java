package ui;

import model.Categories;
import model.Inventory;
import model.ToDoItem;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// BucketList application
public class BucketList {
    private static final String JSON_STORE = "./data/bucketlist.json";
    private Inventory inv;
    private Categories comp;
    private Categories pend;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the Bucketlist application
    public BucketList() throws FileNotFoundException {
        runBucket();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runBucket() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.nextLine();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addToDo();
        } else if (command.equals("d")) {
            deleteToDo();
        } else if (command.equals("m")) {
            completeItem();
        } else if (command.equals("l")) {
            showCurrentList();
        //} else if (command.equals("c")) {
            //showCompleteList();
       // } else if (command.equals("s")) {
            //showAllCategories();
        } else if (command.equals("w")) {
            saveInventory();
        } else if (command.equals("e")) {
            loadInventory();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes Categories and Inventories
    private void init() {
        comp = new Categories("Completed");
        pend = new Categories("Current");
        inv = new Inventory("Hasen's Bucketlist");
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> Add ToDo");
        System.out.println("\td -> Delete ToDo");
        System.out.println("\tm -> Mark ToDo as complete");
        System.out.println("\tl -> Show ToDo's in Category");
        System.out.println("\tc -> Show Completed ToDo");
        System.out.println("\ts -> Show All Categories");
        System.out.println("\tw -> Save BucketList");
        System.out.println("\te -> Load BucketList");
        System.out.println("\tq -> quit");
    }

    // CONSTRAINTS: name of ToDoItem can only take one stringas
    // MODIFIES: this
    // EFFECTS: adds a ToDoItem into list
    private void addToDo() {
        System.out.println("Enter name of ToDo : ");
        String name = input.nextLine();
        ToDoItem td = new ToDoItem(name);
        System.out.println("Set a date : ");
        String date = input.nextLine();
        td.setDate(date);
        System.out.println("Enter Cost Estimate");
        String cost = input.nextLine();
        td.setCost(Double.parseDouble(cost));
        System.out.println("Enter name of Category : ");
        String catName = input.nextLine();
        if (inv.searchForCategory(catName) == null) {
            inv.addCategory(catName);
            inv.searchForCategory(catName).addToDoItemInCategory(td);
        } else {
            inv.searchForCategory(catName).addToDoItemInCategory(td);
        }
    }

    // MODIFIES: this
    // EFFECTS: delete a ToDoItem from Category
    private void deleteToDo() {
        System.out.print("Enter name of Category ToDo is in : ");
        String name = input.nextLine();
        Categories cat = inv.searchForCategory(name);
        if (cat == null) {
            System.out.println("Category not found...");
        } else {
            System.out.println("Enter name of ToDo");
            String toDoName = input.nextLine();
            if (cat.searchForToDo(toDoName) == null) {
                System.out.println("Item Not Found...");
            } else {
                cat.deleteToDo(toDoName);
                System.out.println("To do Deleted Successfully!");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: shows all Current ToDoItems in Category
    private void showCurrentList() {
        System.out.println("Enter name of Category : ");
        String name = input.nextLine();
        Categories cat = inv.searchForCategory(name);
        if (cat == null) {
            System.out.println("Category not Found...");
        } else {
            if (cat.getList().isEmpty()) {
                System.out.println("No more ToDo's!");
            //} else {
               // cat.printCategory(cat.getList());
            }
        }
    }

    //MODIFIES: this
    //EFFECTS: show all Completed ToDoItems in list
    //private void showCompleteList() {
        //if (!comp.getList().isEmpty()) {
            //comp.printCategory(comp.getList());
        //} else {
            //System.out.println("No Completed To Do's!");
        //}
    //}

    //MODIFIES: this
    //EFFECTS: mark Item as completed
    private void completeItem() {
        System.out.println("Enter Category of Item : ");
        String name = input.nextLine();
        Categories cat = inv.searchForCategory(name);
        if (cat == null) {
            System.out.println("Category Not Found...");
        } else {
            System.out.println("Enter Name of ToDo : ");
            String toDoName = input.nextLine();
            if (cat.searchForToDo(toDoName) == null) {
                System.out.println("ToDo Item Not found");
            } else {
                cat.searchForToDo(toDoName).statusCompleted();
                comp.addToDoItemInCategory(cat.searchForToDo(toDoName));
                cat.deleteToDo(toDoName);
                System.out.println("Item marked as Completed!");
            }
        }
    }

    //EFFECTS: Shows all Categories in Inventory
    //private void showAllCategories() {
        //if (!inv.getCategories().isEmpty()) {
            //inv.printAllCategory(inv.getCategories());
        //} else {
           // System.out.println("No Categories To Display");
        //}
    //}

    // EFFECTS: saves Completed Items to file
    private void saveCompletedItems() {
        try {
            jsonWriter.open();
            jsonWriter.writeCategories(comp);
            jsonWriter.close();
            System.out.println("Saved " + "Completed" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //MODIFIES: this
    //EFFECTS: Loads Completed Items from file
    private void loadCompletedItems() {
        try {
            comp = jsonReader.readCategories();
            System.out.println("Loaded " + "Completed" + "from" + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    private void saveInventory() {
        try {
            jsonWriter.open();
            jsonWriter.writeInventory(inv);
            jsonWriter.close();
            System.out.println("Saved" + "BucketList" + "to" + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    private void loadInventory() {
        try {
            inv = jsonReader.readInventory();
            System.out.println("Loaded" + "BucketList" + "from" + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
}
