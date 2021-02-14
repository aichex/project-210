package ui;

import model.Categories;
import model.ToDoItem;

import java.util.Scanner;

// Bank teller application
public class BucketList {
    private Categories cat;
    private ToDoItem tdi;
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
        if (command.equals("t")) {
            addToDo();
        } else if (command.equals("d")) {
            deleteToDo();
        } else if (command.equals("s")) {
            showAllList();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        cat = new Categories("");
        tdi = new ToDoItem("");
        input = new Scanner(System.in);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tt -> add ToDo");
        System.out.println("\td -> delete ToDo");
        System.out.println("\ts -> show all ToDo");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: adds a ToDoItem into list
    private void addToDo() {
        System.out.println("Enter name of ToDo : ");
        String name = input.next();
        ToDoItem td = new ToDoItem(name);
        System.out.println("Set a date : ");
        String date = input.next();
        td.setDate(date);
        cat.addToDoItemInCategory(td);
        System.out.println("ToDo added successfully");
    }

    // MODIFIES: this
    // EFFECTS: conducts a withdraw transaction
    private void deleteToDo() {
        System.out.print("Enter name of ToDo : ");
        String name = input.next();
        if (cat.searchForToDo(name)) {
            cat.deleteToDo(name);
            System.out.println("To do Deleted Successfully!");
        } else {
            System.out.println("Item not found...");
        }
    }

    // MODIFIES: this
    // EFFECTS: shows all ToDoItems in list
    private void showAllList() {
        if (!cat.getList().isEmpty()) {
            cat.printCategory(cat.getList());
        } else {
            System.out.println("No more ToDo's!");
        }
    }
}
