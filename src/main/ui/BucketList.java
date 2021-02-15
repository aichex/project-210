package ui;

import model.Categories;
import model.ToDoItem;

import java.util.Scanner;

// Bank teller application
public class BucketList {
    private Categories comp;
    private Categories pend;
    private Scanner input;

    // EFFECTS: runs the teller application
    public BucketList() {
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
            command = input.next();
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
        } else if (command.equals("s")) {
            showCurrentList();
        } else if (command.equals("c")) {
            showCompleteList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes Categories and Inventories
    private void init() {
        comp = new Categories("Completed");
        pend = new Categories("Current");
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add ToDo");
        System.out.println("\td -> delete ToDo");
        System.out.println("\tm -> Mark ToDo as complete");
        System.out.println("\ts -> show Current ToDo");
        System.out.println("\tc -> show Completed ToDo");
        System.out.println("\tq -> quit");
    }

    // CONSTRAINTS: name of ToDoItem can only take one string
    // MODIFIES: this
    // EFFECTS: adds a ToDoItem into list

    private void addToDo() {
        System.out.println("Enter name of ToDo : ");
        String name = input.next();
        ToDoItem td = new ToDoItem(name);
        System.out.println("Set a date : ");
        String date = input.next();
        td.setDate(date);
        pend.addToDoItemInCategory(td);
        System.out.println("ToDo added successfully");
    }

    // MODIFIES: this
    // EFFECTS: delete a ToDoItem from list
    private void deleteToDo() {
        System.out.print("Enter name of ToDo : ");
        String name = input.next();
        if (pend.searchForToDo(name) == null) {
            System.out.println("Item not found...");
        } else {
            pend.deleteToDo(name);
            System.out.println("To do Deleted Successfully!");
        }
    }

    // MODIFIES: this
    // EFFECTS: shows all Current ToDoItems in list
    private void showCurrentList() {
        if (!pend.getList().isEmpty()) {
            pend.printCategory(pend.getList());
        } else {
            System.out.println("No more ToDo's!");
        }
    }

    //MODIFIES: this
    //EFFECTS: show all Completed ToDoItems in list
    private void showCompleteList() {
        if (!comp.getList().isEmpty()) {
            comp.printCategory(comp.getList());
        } else {
            System.out.println("No Completed ToDo's!");
        }
    }

    //MODIFIES: this
    //EFFECTS: mark Item as completed
    private void completeItem() {
        System.out.println("Enter name of ToDo : ");
        String name = input.next();
        if (pend.searchForToDo(name) == null) {
            System.out.println("Item Not Found...");
        } else {
            comp.addToDoItemInCategory(pend.searchForToDo(name));
            pend.searchForToDo(name).statusCompleted();
            pend.deleteToDo(name);
            System.out.println("Item marked as completed!");
        }
    }
}
