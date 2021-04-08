package ui.tools;

import ui.BucketListGraphical;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a menuBar that allows users to save and load data to and from JSON

public class MenuBar implements ActionListener {
    BucketListGraphical frame;
    JMenuBar menu;
    JMenu menu1;
    JMenuItem menuL;
    JMenuItem menuS;


    //Constructor:
    public MenuBar(BucketListGraphical frame) {
        ImageIcon image1 = new ImageIcon("./data/loading.png");
        Image imageL = image1.getImage();
        Image newImgL = imageL.getScaledInstance(20,20, imageL.SCALE_SMOOTH);
        image1 = new ImageIcon(newImgL);
        ImageIcon image2 = new ImageIcon("./data/Saving.png");
        Image imageS = image2.getImage();
        Image newImgS = imageS.getScaledInstance(20,20, imageS.SCALE_SMOOTH);
        image2 = new ImageIcon(newImgS);

        this.frame = frame;
        menu = new JMenuBar();
        menu1 = new JMenu("File");
        menuL = new JMenuItem("Load", image1);
        menuS = new JMenuItem("Save", image2);
        menu.add(menu1);
        menu1.add(menuL);
        menuL.addActionListener(this);
        menuS.addActionListener(this);
        menu1.add(menuS);
        frame.setJMenuBar(menu);
    }

    //EFFECTS: Allows user to save and load data depending on which SubMenu is selected
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuL) {
            frame.loadInventory();
            System.out.println("this is working");
            frame.initializeList();
            System.out.println("this is working");
        } else if (e.getSource() == menuS) {
            frame.saveInventory();
        }
    }
}
