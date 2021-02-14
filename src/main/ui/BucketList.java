package ui;

import model.Categories;
import model.Inventory;
import model.ToDoItem;

import java.util.Scanner;
// Bank teller application
public class BucketList {
    private Categories cheq;
    private Inventory sav;
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
            doDeposit();
        } else if (command.equals("d")) {
            doWithdrawal();
        } else if (command.equals("s")) {
            doTransfer();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes accounts
    private void init() {
        cheq = new Categories();
        sav = new ToDoItem();
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
    // EFFECTS: conducts a deposit transaction
    private void addToDo() {
        System.out.println("Enter name of ToDo");
        String input = input.next();

        if (amount >= 0.0) {
            selected.deposit(amount);
        } else {
            System.out.println("Cannot deposit negative amount...\n");
        }

        printBalance(selected);
    }

    // MODIFIES: this
    // EFFECTS: conducts a withdraw transaction
    private void doWithdrawal() {
        BucketList selected = selectAccount();
        System.out.print("Enter amount to withdraw: $");
        double amount = input.nextDouble();

        if (amount < 0.0) {
            System.out.println("Cannot withdraw negative amount...\n");
        } else if (selected.getBalance() < amount) {
            System.out.println("Insufficient balance on account...\n");
        } else {
            selected.withdraw(amount);
        }

        printBalance(selected);
    }

    // MODIFIES: this
    // EFFECTS: conducts a transfer transaction
    private void doTransfer() {
        System.out.println("\nTransfer from?");
        BucketList source = selectAccount();
        System.out.println("Transfer to?");
        BucketList destination = selectAccount();

        System.out.print("Enter amount to transfer: $");
        double amount = input.nextDouble();

        if (amount < 0.0) {
            System.out.println("Cannot transfer negative amount...\n");
        } else if (source.getBalance() < amount) {
            System.out.println("Insufficient balance on source account...\n");
        } else {
            source.withdraw(amount);
            destination.deposit(amount);
        }

        System.out.print("Source ");
        printBalance(source);
        System.out.print("Destination ");
        printBalance(destination);
    }

    // EFFECTS: prompts user to select chequing or savings account and returns it
    private BucketList selectAccount() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("c") || selection.equals("s"))) {
            System.out.println("c for chequing");
            System.out.println("s for savings");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("c")) {
            return cheq;
        } else {
            return sav;
        }
    }

    // EFFECTS: prints balance of account to the screen
    private void printBalance(BucketList selected) {
        System.out.printf("Balance: $%.2f\n", selected.getBalance());
    }
