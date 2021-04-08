package ui.tools;

import ui.BucketListGraphical;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

// Represents a textField that allows users to input the name of Category to add into Inventory and show in JList

public class CategoryNameTool extends TextField {

    //Constructor:
    public CategoryNameTool(BucketListGraphical frame, JComponent parent) {
        super(frame, parent);
    }


    // MODIFIES: this
    // EFFECTS: Create a new listener object and adds it to text field
    @Override
    protected void addListener() {
        textField.getDocument().addDocumentListener(new NameToolHandler());
    }

    private class NameToolHandler implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            changed();

        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            changed();

        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            changed();

        }

        // MODIFIES: BucketListGraphicalUI
        // EFFECTS: enables the add button when text field is not empty
        private void changed() {
            String name = textField.getText();

            if (!name.isEmpty()) {
                frame.getAdd().setEnabled(true);
            } else {
                frame.getAdd().setEnabled(false);
            }
        }
    }
}

