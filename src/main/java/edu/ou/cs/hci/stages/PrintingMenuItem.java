package edu.ou.cs.hci.stages;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * A menu item that prints its description when clicked.
 */
public class PrintingMenuItem extends JMenuItem{
    public String descToPrint;

    public PrintingMenuItem(String name, String descToPrint){
        super(name);
        this.descToPrint = descToPrint;
        addActionListener((event)->{
            System.out.println(name + ":" + descToPrint);
        });
    }

    public PrintingMenuItem(String name, String descToPrint, ImageIcon icon){
        this(name, descToPrint);
        setIcon(icon);
    }

}
