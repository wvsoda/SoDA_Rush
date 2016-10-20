
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
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import entity.Enemy;
import main.GameController;

public class GamePane extends JFrame implements KeyListener, ActionListener
{
    private GameController gameController;

    private Set<Enemy> enemies;

    private Image wvlogo;
    private Image mclogo;

    private char dir;

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

        enemies = new HashSet<Enemy>();

        initImageIcons();

        addKeyListener(this);
        setSize(600, 600);
        setVisible(true);
        this.setBackground(Color.decode("#F44336"));
    }

    // Receives important references from GameController and keeps track of them
    public void initReferencesToGameController(GameController gc, Set<Enemy> enems)
    {
        gameController = gc;
        enemies = enems;
    }

    // This function is in charge of timing, as it calls GameController's play()
    // method
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

        // Calls GameController's play() method
        gameController.play();
    }

    public void paintOffScreen(Graphics g)
    {
        for (Enemy enemy : enemies)
        {
            g.drawImage(mclogo, (int) enemy.getX(), (int) enemy.getY(),100,100, this);
        }

        Graphics2D g2d = (Graphics2D) g; // Create a Java2D version of g.

        double angle = gameController.getPlayerAngle();
        // g.drawImage(, x, y, width, height, observer)
        
        int widthAdjust = 50;
        int heightAdjust = 58;
        g2d.translate(300 + widthAdjust, 300 + heightAdjust); // Translate the center of our coordinates.
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
        g2d.drawImage(wvlogo, -widthAdjust, -heightAdjust, 100, 100, this);

        gameController.updatePlayerDirection(dir);
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

    // Initializes the image icons
    // TODO: Use resources instead of file paths
    private void initImageIcons()
    {
        wvlogo = (new ImageIcon("wvlogo.png")).getImage();
        mclogo = (new ImageIcon("mclogo.png")).getImage();

    }
}
