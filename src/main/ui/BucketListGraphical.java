package ui;

import java.io.IOException;

import com.sun.tools.javac.comp.Flow;
import model.Inventory;
import model.Categories;
import model.ToDoItem;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.tools.AddTool;
import ui.tools.NameTool;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BucketListGraphical extends JFrame {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;
    private static final String JSON_STORE = "./data/bucketlist.json";
    private JPanel textPanel;
    private JList textArea;
    private ToDoItem item;
    private Inventory inv;
    private Categories comp;
    private DefaultListModel inventory;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private AddTool add;
    private NameTool name;
    private ImageIcon icon;


    public BucketListGraphical() throws FileNotFoundException {
        super("My BucketList");
        init();
        initializeFields();
        initializeGraphics();
        createTextPanel();
        createTools();
    }

    private void createTextPanel() {
        textPanel = new JPanel();
        textArea = new JList(initializeList());
        textPanel.setPreferredSize(new Dimension(WIDTH * 2 / 3, HEIGHT));

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(WIDTH * 2 / 3 - 10, HEIGHT - 100));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        textArea.setBackground(Color.WHITE);
        textArea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        textArea.setSelectedIndex(0);
        textArea.setFont(new Font("Cambria", Font.BOLD, 18));

        textPanel.add(scroll);
        add(textPanel, BorderLayout.CENTER);
    }

    public DefaultListModel initializeList() {
        inventory = new DefaultListModel();
        for (int i = 0; i < inv.getCategories().size(); i++) {
            inventory.addElement(inv.getCategories().get(i).getCategoryName());
        }
        return inventory;
    }

    // MODIFIES: this
    // EFFECTS: initializes Categories and Inventories
    private void init() {
        comp = new Categories("Completed");
        inv = new Inventory("Hasen's Bucketlist");
        inv.addCategory(comp);
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    public void initializeFields() {
    }

    public void createTools() {
        JPanel toolArea = new JPanel(new FlowLayout());
        JLabel label = new JLabel(icon);
        icon = new ImageIcon(getClass().getResource("mario.png"));
        label.setBounds(20,20,15,15);
        toolArea.add(label);

        toolArea.setBackground(Color.gray);
        toolArea.setLayout(new FlowLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        toolArea.setSize(new Dimension(0, 0));
        add(toolArea, BorderLayout.WEST);

        add = new AddTool(this, toolArea);
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        name = new NameTool(this, toolArea);
    }

    public void initializeGraphics() {
        setLayout(new BorderLayout());
        setSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }



    public static void main(String[] args) {
        try {
            new BucketListGraphical();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: File not found");
        }
    }

    private void loadInventory() {
        try {
            inv = jsonReader.readInventory();
            initializeList();
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
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

    public void initializeNewField() {
        JPanel test = new JPanel(new FlowLayout());
        icon = new ImageIcon(getClass().getResource("mario.png"));
        JLabel label = new JLabel(icon);
        test.add(label);
        add(test,BorderLayout.NORTH);
    }
}