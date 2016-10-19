
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import main.GameController;

public class GamePane extends JFrame implements KeyListener, ActionListener
{
    GameController gameController;

    Image wvlogo;
    char dir;

    public GamePane()
    {
        super("SoDA Rush");
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(WindowEvent evt)
            {
                System.exit(0);
            }
        });

        // TODO: Turn into resource
        wvlogo = (new ImageIcon("newwvlogo.png")).getImage();
        addKeyListener(this);
        setSize(600, 600);
        setVisible(true);
        this.setBackground(Color.decode("#F44336"));
    }

    public void initGameControllerFromInstance(GameController gc)
    {
        gameController = gc;
    }

    public void paint(Graphics g)
    {
        // gra = g;
        Image offImage = createImage(748, 748);
        // if (offImage == null) offImage = createImage(748,748);
        // Creates an off-screen drawable image to be used for
        // double buffering; XSIZE, YSIZE are each of type ‘int’
        Graphics buffer = offImage.getGraphics();
        // Creates a graphics context for drawing to an
        // off-screen image
        paintOffScreen(buffer); // your own method
        g.drawImage(offImage, 0, 0, null);
        // draws the image with upper left corner at 0,0
    }

    public void paintOffScreen(Graphics g)
    {
        double angle = gameController.getPlayerAngle();
        // g.drawImage(, x, y, width, height, observer)
        Graphics2D g2d = (Graphics2D) g; // Create a Java2D version of g.
        g2d.translate(300, 300); // Translate the center of our coordinates.
        switch (dir)
        {
            case 'd':
                angle += 0.2;
                break;
            case 'a':
                angle -= 0.2;
                break;
        }
        g2d.rotate(angle);
        g2d.drawImage(wvlogo, -50, -60, 100, 100, this);

        gameController.updatePlayerAngle(angle);
    }

    @Override
    public void keyTyped(KeyEvent event)
    {

    }

    @Override
    public void keyPressed(KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.VK_D)
            dir = 'd';
        else if (event.getKeyCode() == KeyEvent.VK_A)
            dir = 'a';


    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        dir = '-';

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        this.repaint();
    }
}
