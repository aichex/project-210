package ui.tools;


import ui.BucketListGraphical;

import javax.swing.*;

//Represents an abstract tool that creates a button. Requires a JFrame and JComponent designation
public abstract class Tool {
    JButton button;
    protected BucketListGraphical frame;

    //Constructor:
    public Tool(BucketListGraphical frame, JComponent parent) {
        this.frame = frame;
        createButton(parent);
        addToParent(parent);
        addListener();
    }

    //EFFECTS: Creates a button for Tool
    protected abstract void createButton(JComponent parent);

    //EFFECTS: Creates a Listener for the Button of the Tool
    protected abstract void addListener();

    // MODIFIES: this
    // EFFECTS: sets the button to enabled to disabled
    public void setEnabled(boolean b) {
        button.setEnabled(b);
    }

    //MODIFIES: parent
    //EFFECTS: Adds tool to given JComponent
    public void addToParent(JComponent parent) {
        parent.add(button);
    }
}
