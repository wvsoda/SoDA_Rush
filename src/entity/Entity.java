
package entity;

public abstract class Entity
{
    protected int xCoord;
    protected int yCoord;
    protected double angle;

    public Entity(int x, int y)
    {
        xCoord = x;
        yCoord = y;
        angle = 0.0;
    }

    public void move(int newX, int newY)
    {
        xCoord = newX;
        yCoord = newY;
    }
}
