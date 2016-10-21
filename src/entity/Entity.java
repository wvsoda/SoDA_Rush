
package entity;

public abstract class Entity
{
    protected String image;
    protected double xCoord;
    protected double yCoord;
    protected double angle;

    public int hitBoxRadius;
    protected boolean killed;
    public Entity()
    {
        xCoord = 0;
        yCoord = 0;
        angle = 0.0;
        image = "";
        hitBoxRadius = 10;
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

    public double getHitBoxRadius()
    {
        return hitBoxRadius;
    }
    
    public boolean isKilled()
    {
        return killed;
    }
    
    public void kill()
    {
        killed = true;
    }
    
    abstract public void move();

}
