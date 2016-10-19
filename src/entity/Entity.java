
package entity;

public abstract class Entity
{
    protected double slope;
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

    abstract public void move();

}
