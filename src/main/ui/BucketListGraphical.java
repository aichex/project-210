package ui;

import model.Categories;
import model.Inventory;
import model.ToDoItem;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tools.*;
import ui.tools.MenuBar;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BucketListGraphical extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    private static final String JSON_STORE = "./data/bucketlist.json";
    private ToDoItem item;
    private JSplitPane textPanel;
    private JList<Categories> listArea;
    private JScrollPane scroll;
    private Inventory inv = new Inventory("Hasen's BucketList");
    private Categories comp;
    private DefaultListModel inventory;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private AddCategoryTool add;
    private CategoryNameTool catName;
    private AddToDoTool addToDo;
    private ToDoNameTool toDoName;
    private MenuBar menu;
    private JLabel label;

    //Main GUI

    //Constructor:
    public BucketListGraphical() throws FileNotFoundException {
        super("My BucketList");
        init();
        initializeGraphics();
        createTools();
        createTextPanel();
    }

    //getter:
    public AddCategoryTool getAdd() {
        return this.add;
    }

    public String getCategoryName() {
        return catName.getText();
    }

    public String getToDoName() {
        return toDoName.getText();
    }

    //MODIFIES: this
    //EFFECTS: creates the text panel that shows list of Categories and ToDoItems and adds to Frame
    public void createTextPanel() {
        textPanel = new JSplitPane();
        listArea = new JList(initializeList());
        JPanel panel = new JPanel();
        label = new JLabel();
        panel.add(label);
        listArea.getSelectionModel().addListSelectionListener(e -> {
            Categories c = listArea.getSelectedValue();
            if (c != null) {
                label.setText(c.getItems(c.getList()));
            }
        });
        textPanel.setPreferredSize(new Dimension(WIDTH * 2 / 3, HEIGHT));
        textPanel.setLeftComponent(scroll);
        textPanel.setRightComponent(panel);
        scroll = new JScrollPane(listArea);
        scroll.setPreferredSize(new Dimension(WIDTH * 1 / 3 - 10, HEIGHT - 100));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listArea.setSelectedIndex(0);
        textPanel.add(scroll);
        add(textPanel, BorderLayout.CENTER);
    }

    //MODIFIES: this
    //EFFECTS: Creates a new DefaultListModel that iterates through Inventory class
    public DefaultListModel initializeList() {
        inventory = new DefaultListModel<Categories>();
        for (int i = 0; i < inv.getCategories().size(); i++) {
            inventory.addElement(inv.getCategories().get(i));
        }
        return inventory;
    }

    //EFFECTS: Takes textField entry and adds Element into DefaultListModel
    public void updateList() {
        inventory.addElement(catName.getText());
    }

    // MODIFIES: this
    // EFFECTS: initializes Category and Inventory class along with JSONWriter and JSONReader
    private void init() {
        comp = new Categories("Completed");
        item = new ToDoItem("Mikus");
        comp.addToDoItemInCategory(item);
        comp.addToDoItemInCategory(new ToDoItem("Minami"));
        inv.addCategory(comp);
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    //MODIFIES: this
    //EFFECTS: Creates Panel for all Tools in GUI and initializes the tools
    public void createTools() {
        JPanel toolArea = new JPanel();
        toolArea.setBackground(Color.gray);
        toolArea.setLayout(new GridLayout(4, 1, 20, 20));
        add = new AddCategoryTool(this, toolArea);
        catName = new CategoryNameTool(this, toolArea);
        addToDo = new AddToDoTool(this, toolArea);
        toDoName = new ToDoNameTool(this, toolArea);
        add(toolArea, BorderLayout.WEST);
    }

    //MODIFIES: this
    //EFFECTS: Initializes the Frame and sets Frame as visible
    public void initializeGraphics() {
        setLayout(new BorderLayout());
        setSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        menu = new MenuBar(this);
        setVisible(true);
    }

    //MODIFIES this and Inventory
    //EFFECTS: Adds Category into Inventory List
    public void addCategory(Categories c) {
        inv.addCategory(c);
    }

    //MODIFIES this and Category
    //EFFECTS: Adds ToDoItem into Completed Category
    public void addToDo(ToDoItem i) {
        inv.searchForCategory("Completed").addToDoItemInCategory(i);
    }

    //MODIFIES: this
    //EFFECTS: Loads JSON file to display on panel that shows List of Categories and ToDoItems
    public void loadInventory() {
        try {
            inv = jsonReader.readInventory();
            listArea.setModel(initializeList());
            System.out.println("this is working");
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //EFFECTS: Saves current List of Categories and ToDoItems in a JSONFile
    public void saveInventory() {
        try {
            jsonWriter.open();
            jsonWriter.writeInventory(inv);
            jsonWriter.close();
            System.out.println("Saved" + "BucketList" + "to" + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    public static void main(String[] args) {
        try {
            new BucketListGraphical();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: File not found");
        }
    }
}
