package ui.tools;

import ui.BucketListGraphical;

import javax.swing.*;
import java.awt.*;

public abstract class TextField {
    BucketListGraphical frame;
    JTextField textField;

    public TextField(BucketListGraphical frame, JComponent parent) {
        this.frame = frame;
        textField = new JTextField(10);
        textField.setPreferredSize(new Dimension(100,10));
        addToParent(parent);
    }

    // MODIFIES: parent
    // EFFECTS: add the text field to the parent component with the given constraints
    private void addToParent(JComponent parent) {
        parent.add(textField);
    }

    // EFFECTS: add listener to the text field
    protected abstract void addListener();

    // EFFECTS: return the string in the text field
    public String getText() {
        return textField.getText();
    }
}