package edu.ou.cs.hci.stages;

import edu.ou.cs.hci.resources.Resources;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Card extends JLabel{
    String name;
    String path;
    String descText;
    String flavorText;
    String type;
    String manaString;

    ImageIcon icon;
    Color color;
    static String[] colors = { "#F44336", "#4CAF50", "#FFFFFF"};
    static Random r = new Random();

    public Card(String name, String manaString, String descText, String flavorText, String type,  String path){
        this.name = name;
        this.manaString = manaString;
        this.descText = descText;
        this.flavorText = flavorText;
        this.type = type;
        this.path = path;
        try {
            this.icon = Resources.getImage("img/" + path);
        }catch (Exception e){
            this.icon = Resources.getImage("img/19.jpg");
        }
        createBorderFromString();
    }

    private void createBorderFromString() {
        String color = null;
        for(char c : manaString.toCharArray()){
            if(c == 'G'){
                color = "#4CAF50";
                break;
            }

            if(c == 'W'){
                color = "#FFFFFF";
                break;
            }

            if(c == 'U'){
                color = "#00BCD4";
                break;
            }
            if(c == 'B'){
                color = "#212121";
                break;
            }

            if(c =='R'){
                color = "#F44336";
                break;
            }
        }
        if(color != null){
            this.color = Color.decode(color);
            this.setBorder(new LineBorder(this.color,5));
        }
    }

    public static Color getRandomColor(){
        return Color.decode(colors[r.nextInt(5)]);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(icon.getImage(),0,0,getWidth(),getHeight(),this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescText() {
        return descText;
    }

    public void setDescText(String descText) {
        this.descText = descText;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManaString() {
        return manaString;
    }

    public void setManaString(String manaString) {
        this.manaString = manaString;
    }
}
