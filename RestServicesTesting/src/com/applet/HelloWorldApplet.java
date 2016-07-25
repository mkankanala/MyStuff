package com.applet;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.*;

public class HelloWorldApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello world!", 50, 25);
       
        TextField distanceText = new TextField(10);
        TextField accelerationText = new TextField(10);
        Button launch = new Button("LAUNCH!");
       
    }
}