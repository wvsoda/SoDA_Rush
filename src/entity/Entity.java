
package entity;

public abstract class Entity
{
    protected String image;
    protected double xCoord;
    protected double yCoord;
    protected double angle;

    public Entity()
    {
        xCoord = 0;
        yCoord = 0;
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
