package ui.tools;

import model.Categories;
import ui.BucketListGraphical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a button that allows User to add a Category into Inventory and show in JList

public class AddCategoryTool extends Tool {
    private Categories cat;

    //Constructor:
    public AddCategoryTool(BucketListGraphical frame, JComponent parent) {
        super(frame, parent);
    }

    //MODIFIES: this
    //EFFECTS: Creates a new button and adds it to Parent JComponent
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add Category");
        addToParent(parent);
    }

    //MODIFIES: this
    //EFFECTS: Create a new Listener object and adds it to the button connected to the tool
    @Override
    protected void addListener() {
        button.addActionListener(new AddToolHandler());
    }

    private class AddToolHandler implements ActionListener {

        //MODIFIES: Category and BucketListGraphicalUI
        //EFFECTS: When button is pressed, adds Category into Inventory and Updates JList in Main frame
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = frame.getCategoryName();
            cat = new Categories(name);
            frame.addCategory(cat);
            frame.updateList();
        }
    }
}