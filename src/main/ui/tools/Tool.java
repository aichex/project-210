package ui.tools;

import model.ToDoItem;
import model.Categories;
import model.Inventory;
import ui.BucketListGraphical;

import javax.swing.*;

public abstract class Tool {
    JButton button;
    protected BucketListGraphical frame;
    private boolean active;

    public Tool(BucketListGraphical frame, JComponent parent) {
        this.frame = frame;
        createButton(parent);
        addToParent(parent);
        active = false;
        addListener();
    }

    protected JButton customizeButton(JButton button) {
        button.setBorderPainted(true);
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        return button;
    }

    //getters
    public boolean isActive() {
        return active;
    }

    public void activate() {
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    protected abstract void createButton(JComponent parent);

    protected abstract void addListener();


    public void addToParent(JComponent parent) {
        parent.add(button);
    }
}
