package ui.tools;

import model.Categories;
import ui.BucketListGraphical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCategoryTool extends Tool {
    private Categories cat;


    public AddCategoryTool(BucketListGraphical frame, JComponent parent) {
        super(frame, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add Category");
        addToParent(parent);


    }

    @Override
    protected void addListener() {
        button.addActionListener(new AddToolHandler());
    }

    private class AddToolHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = frame.getCategoryName();
            cat = new Categories(name);
            frame.addCategory(cat);
            frame.updateList();
        }
    }
}