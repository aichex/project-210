package ui.tools;


import model.ToDoItem;
import ui.BucketListGraphical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddToDoTool extends Tool {
    private ToDoItem toDo;

    //Button tht allows user to input a To-Do item into Completed Category

    public AddToDoTool(BucketListGraphical frame, JComponent parent) {
        super(frame, parent);
    }

    //MODIFIES: this
    //EFFECTS: Creates a new button and adds it to Parent JComponent
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add ToDo to Completed");
        addToParent(parent);

    }

    //MODIFIES: this
    //EFFECTS: Create a new Listener object and adds it to the button connected to the tool
    @Override
    protected void addListener() {
        button.addActionListener(new AddToDoTool.AddToDoHandler());

    }

    private class AddToDoHandler implements ActionListener {

        //MODIFIES: BucketListGraphicalUI
        // EFFECTS: Given text input, create a new To-Do Item with given name and adds it to frame
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = frame.getToDoName();
            toDo = new ToDoItem(name);
            frame.addToDo(toDo);

        }
    }
}
