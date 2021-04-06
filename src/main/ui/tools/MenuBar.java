package ui.tools;

import ui.BucketListGraphical;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar implements ActionListener {
    BucketListGraphical frame;
    JMenuBar menu;
    JMenu menu1;
    JMenuItem menuL;
    JMenuItem menuS;

    public MenuBar(BucketListGraphical frame) {
        this.frame = frame;
        menu = new JMenuBar();
        menu1 = new JMenu("File");
        menuL = new JMenuItem("Load", new ImageIcon("loading.png"));
        menuS = new JMenuItem("Save", new ImageIcon("Saving.png"));
        menu.add(menu1);
        menu1.add(menuL);
        menuL.addActionListener(this);
        menuS.addActionListener(this);
        menu1.add(menuS);
        frame.setJMenuBar(menu);
    }

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
