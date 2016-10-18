
package entity;

public abstract class Entity
{
    protected String image;
    protected int xCoord;
    protected int yCoord;
    protected double angle;

    public Entity(int x, int y, String img)
    {
        xCoord = x;
        yCoord = y;
        angle = 0.0;
        image = img;
    }

    public double getAngle()
    {
        return angle;
    }

    abstract public void move();

}
