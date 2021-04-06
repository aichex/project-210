package ui;

import model.Categories;
import model.Inventory;
import model.ToDoItem;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tools.*;
import ui.tools.MenuBar;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    public AddCategoryTool add;
    public CategoryNameTool catName;
    public AddToDoTool addToDo;
    public ToDoNameTool toDoName;
    private MenuBar menu;


    public BucketListGraphical() throws FileNotFoundException {
        super("My BucketList");
        init();
        initializeGraphics();
        createTools();
        createTextPanel();
    }

    public void createTextPanel() {
        textPanel = new JSplitPane();
        listArea = new JList(initializeList());
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        panel.add(label);
        listArea.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Categories c = listArea.getSelectedValue();
                label.setText(c.getItems(c.getList()));
            }
        });

        textPanel.setPreferredSize(new Dimension(WIDTH * 2 / 3, HEIGHT));

        textPanel.setLeftComponent(scroll);
        textPanel.setRightComponent(panel);
        scroll = new JScrollPane(listArea);
        scroll.setPreferredSize(new Dimension(WIDTH * 1 / 3 - 10, HEIGHT - 100));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        listArea.setBackground(Color.WHITE);
        listArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listArea.setSelectedIndex(0);
        textPanel.add(scroll);
        add(textPanel, BorderLayout.CENTER);
    }

    public DefaultListModel initializeList() {
        inventory = new DefaultListModel<Categories>();
        for (int i = 0; i < inv.getCategories().size(); i++) {
            inventory.addElement(inv.getCategories().get(i));
        }
        return inventory;
    }

    public void updateList() {
        inventory.addElement(catName.getText());
    }

    // MODIFIES: this
    // EFFECTS: initializes Categories and Inventories
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

    public void createTools() {
        JPanel toolArea = new JPanel();
        toolArea.setBackground(Color.gray);
        toolArea.setLayout(new GridLayout(4,1, 20, 20));
        add = new AddCategoryTool(this, toolArea);
        catName = new CategoryNameTool(this, toolArea);
        addToDo = new AddToDoTool(this, toolArea);
        toDoName = new ToDoNameTool(this, toolArea);
        add(toolArea, BorderLayout.WEST);
    }

    public void initializeGraphics() {
        setLayout(new BorderLayout());
        setSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        menu = new MenuBar(this);
        setVisible(true);
    }

    public String getCategoryName() {
        return catName.getText();
    }

    public String getToDoName() {
        return toDoName.getText();
    }

    public void addCategory(Categories c) {
        inv.addCategory(c);
    }

    public void addToDo(ToDoItem i) {
        inv.searchForCategory("Completed").addToDoItemInCategory(i);
    }


    public static void main(String[] args) {
        try {
            new BucketListGraphical();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: File not found");
        }
    }

    public void loadInventory() {
        try {
            inv = jsonReader.readInventory();
            listArea.setModel(initializeList());
            System.out.println("this is working");
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

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
}
