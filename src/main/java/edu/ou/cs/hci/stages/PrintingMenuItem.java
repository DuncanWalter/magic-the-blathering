package edu.ou.cs.hci.stages;

import javax.swing.*;

/**
 * A menu item that prints its description when clicked.
 */
public class PrintingMenuItem extends JMenuItem{
    public final String descToPrint;

    public PrintingMenuItem(String name, String descToPrint){
        super(name);
        this.descToPrint = descToPrint;
        //addActionListener((event)-> System.out.println(name + ":" + descToPrint));
    }

    public PrintingMenuItem(String name, String descToPrint, ImageIcon icon){
        this(name, descToPrint);
        setIcon(icon);
    }

}
