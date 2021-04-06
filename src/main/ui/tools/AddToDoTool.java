package ui.tools;

import model.Categories;
import model.ToDoItem;
import ui.BucketListGraphical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToDoTool extends Tool {
    private ToDoItem toDo;

    public AddToDoTool(BucketListGraphical frame, JComponent parent) {
        super(frame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add ToDo to Completed");
        addToParent(parent);

    }

    @Override
    protected void addListener() {
        button.addActionListener(new AddToDoTool.AddToDoHandler());

    }

    private class AddToDoHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = frame.getToDoName();
            toDo = new ToDoItem(name);
            frame.addToDo(toDo);

        }
    }
}
