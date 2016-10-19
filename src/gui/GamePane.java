package thing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


import java.util.*;



import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.*;
public class Test extends JFrame implements KeyListener, ActionListener{
    Image wvlogo, mclogo;
    double angle;
    char dir;
    double xcoord, ycoord;
    
    public Test() {
        super("ashgdjkflgrd");
         addWindowListener(new java.awt.event.WindowAdapter() {
             public void windowClosing(WindowEvent evt) {
                 System.exit(0);
             }
         });
        wvlogo = (new ImageIcon("newwvlogo.png")).getImage();
        mclogo = (new ImageIcon("mtcarmel.png")).getImage();
        addKeyListener(this);
        setSize(600,600);
        setVisible(true);
        dir = '-';
        Timer timer = new javax.swing.Timer(50, this);
        timer.start();  
        angle = 0;
        xcoord = 550;
        ycoord = 0;
        this.setBackground(Color.decode("#F44336"));;
    }

    public void paint(Graphics g)
    {
        //gra = g;
        Image offImage = createImage(748,748);
        //if (offImage == null) offImage = createImage(748,748);
        // Creates an off-screen drawable image to be used for
        // double buffering; XSIZE, YSIZE are each of type ‘int’
        Graphics buffer = offImage.getGraphics();
        // Creates a graphics context for drawing to an 
        // off-screen image
        paintOffScreen(buffer);     // your own method
        g.drawImage(offImage, 0, 0, null);  
        // draws the image with upper left corner at 0,0
    }
    
    public void paintOffScreen(Graphics g)
    {
        //g.drawImage(, x, y, width, height, observer)
        g.drawImage(mclogo, (int)xcoord, (int)ycoord, 100, 100, this);
        Graphics2D g2d=(Graphics2D)g; // Create a Java2D version of g.
        //Graphics2D g3d=(Graphics2D)g;
        g2d.translate(300, 300); // Translate the center of our coordinates.
        switch(dir) {
        case 'a':
            angle += 0.2;
            break; 
        case 'd':
            angle -= 0.2;
            break; 
        }
        g2d.rotate(angle);
        
        g2d.drawImage(wvlogo, -50, -60, 100, 100, this);
        //g3d.rotate(Math.PI*0.25);
        
        System.out.println(xcoord+ " "+ycoord);
        
        
    }
    
    @Override
    public void keyTyped(KeyEvent event) {
        
        
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_A)
            dir = 'a';
        else if (event.getKeyCode() == KeyEvent.VK_D)
            dir = 'd';
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        dir = '-';
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
        xcoord -=1;
        ycoord +=1;
        if(ycoord>=600){
            ycoord=0;
            xcoord=550;
        }
        
    }
    
    public static void main(String[] args)
    {
        Test t = new Test();
        Test u = t;
        System.out.println(t+" "+u);
    }
}
