package ui.tools;

import ui.BucketListGraphical;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CategoryNameTool extends TextField {
    public CategoryNameTool(BucketListGraphical frame, JComponent parent) {
        super(frame, parent);
    }

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

        // MODIFIES: todoList
        // EFFECTS: enables the add button when text field is not empty and other conditions
        private void changed() {
            String name = textField.getText();

            if (!name.isEmpty()) {
                frame.add.setEnabled(true);
            } else {
                frame.add.setEnabled(false);
            }
        }
    }
}

