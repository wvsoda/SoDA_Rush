
package entity;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class Entity
{
    protected Image image;
    protected int xCoord;
    protected int yCoord;
    protected double angle;

    public Entity(int x, int y, String img)
    {
        xCoord = x;
        yCoord = y;
        angle = 0.0;
        image = (new ImageIcon(img)).getImage();
    }

    public double getAngle()
    {
        return angle;
    }

    abstract public void move();

}
