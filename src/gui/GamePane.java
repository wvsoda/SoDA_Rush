
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
import entity.Bullet;
import main.GameController;

public class GamePane extends JFrame implements KeyListener, ActionListener
{
    private GameController gameController;

    private Set<Enemy> enemies;
    private Set<Bullet> Bullets;
    private Image wvlogo;
    private Image mclogo;
    private Image pencil;
    private Image collegeboard;
    private Image sundevil;

    private char dir;
    boolean bulletShot;
    
    boolean variety = true;     //////////////////////If you want some variety in your enemies, set this to true. /////////////////
    
    
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
        this.setIconImage(pencil);
        setVisible(true);
        //wthis.setBackground(Color.decode("#F44336"));
        bulletShot = false;
    }

    // Receives important references from GameController and keeps track of them
    public void initReferencesToGameController(GameController gc, Set<Enemy> enems, Set<Bullet> projectile)
    {
        gameController = gc;
        enemies = enems;
        Bullets = projectile;
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
            if (variety == true)
            {
                switch (enemy.getImage())
                {
                    case 0:
                        g.drawImage(collegeboard, (int) enemy.getX(), (int) enemy.getY(),100,100, this);
                        enemy.hitBoxRadius = 30;
                        break;
                    case 1:
                        g.drawImage(mclogo, (int) enemy.getX(), (int) enemy.getY(),100,100, this);
                        enemy.hitBoxRadius = 50;
                        break;
                    case 2:
                        g.drawImage(sundevil, (int) enemy.getX(), (int) enemy.getY(),100,100, this);
                        enemy.hitBoxRadius = 50;
                        break;
                }
            }
            else
            {
                g.drawImage(mclogo, (int) enemy.getX(), (int) enemy.getY(),100,100, this);
                enemy.hitBoxRadius = 50;
            }
        }
        
        for (Bullet bullet : Bullets)
        {
            g.drawImage(pencil, (int) bullet.getX(), (int) bullet.getY(),20,20,this);
        }

        Graphics2D g2d = (Graphics2D) g; // Create a Java2D version of g.

        double angle = gameController.getPlayerAngle();
        // g.drawImage(, x, y, width, height, observer)
        
        int widthAdjust = 0;
        int heightAdjust = 0;
        g2d.translate(300 + widthAdjust, 300 + heightAdjust); // Translate the center of our coordinates.
        switch (dir)
        {
            case 'w':
                if(!bulletShot)
                {
                    gameController.shootBullet();
                    bulletShot = true;
                }
                break;
            case 'd':
                angle += 0.2;
                break;
            case 'a':
                angle -= 0.2;
                break;
        }
        g2d.rotate(angle);
        g2d.drawImage(wvlogo, -50, -58, 100, 100, this);

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
        else if (event.getKeyCode() == KeyEvent.VK_W)
            dir = 'w';

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        dir = '-';
        bulletShot = false;

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
        pencil = (new ImageIcon("cannonball.png")).getImage();
        collegeboard = (new ImageIcon ("collegebaord.png")).getImage();
        sundevil = (new ImageIcon ("sundevil.png")).getImage();


    }
}
