
package entity;

public abstract class Entity
{
    protected String image;
    protected int xCoord;
    protected int yCoord;
    protected double angle;

    public Entity(int x, int y)
    {
        xCoord = x;
        yCoord = y;
        angle = 0.0;
        image = "";
    }

    public double getAngle()
    {
        return angle;
    }

    public double getX()
    {
        return xCoord;
    }

    public double getY()
    {
        return yCoord;
    }

    abstract public void move();

}
