package ui.tools;

import ui.BucketListGraphical;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ToDoNameTool extends TextField {
    public ToDoNameTool(BucketListGraphical frame, JComponent parent) {
        super(frame, parent);
    }

    //TextField that allows user to input name of ToDoItem they wish to add into Completed Category

    // MODIFIES: this
    // EFFECTS: Create a new listener object and adds it to text field

    @Override
    protected void addListener() {
        textField.getDocument().addDocumentListener(new ToDoNameTool.ToDoNameHandler());
    }

    private class ToDoNameHandler implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            changes();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            changes();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            changes();
        }
    }

    // MODIFIES: BucketListGraphicalUI
    // EFFECTS: enables the add button when text field is not empty
    private void changes() {
        String name = textField.getText();

        if (!name.isEmpty()) {
            frame.getAdd().setEnabled(true);
        } else {
            frame.getAdd().setEnabled(false);
        }
    }
}
