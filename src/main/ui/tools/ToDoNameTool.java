package ui.tools;

import ui.BucketListGraphical;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ToDoNameTool extends TextField {
    public ToDoNameTool(BucketListGraphical frame, JComponent parent) {
        super(frame, parent);
    }

    @Override
    protected void addListener() {
        textField.getDocument().addDocumentListener(new ToDoNameTool.ToDoNameHandler());

    }

    private class ToDoNameHandler implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {

        }

        @Override
        public void removeUpdate(DocumentEvent e) {

        }

        @Override
        public void changedUpdate(DocumentEvent e) {

        }
    }
}
