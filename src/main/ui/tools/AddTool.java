package ui.tools;

import model.Categories;
import ui.BucketListGraphical;

import javax.swing.*;

public class AddTool extends Tool {
    private Categories cat;


    public AddTool(BucketListGraphical frame, JComponent parent) {
        super(frame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add Item");
        addToParent(parent);


    }

    @Override
    protected void addListener() {

    }
}